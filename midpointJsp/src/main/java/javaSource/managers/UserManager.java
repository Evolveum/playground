package javaSource.managers;

import javaSource.User;
import javaSource.errors.ErrorMessage;
import javaSource.errors.NotLoggedException;

import javax.servlet.http.HttpSession;

public class UserManager {
	private HttpSession session = null;
	public final String userName = "userName";
	public final String userPass = "userPass";
	public final String userFirstName = "userFirstName";
	public final String userLastName = "userLastName";
	public UserManager(HttpSession session) {
	        this.session = session;
	    }
	
	public boolean login(String name, String password) {
		User user = new User();
        if(user.getUserName().equals(name) && user.getUserPass().equals(password)){
        	session.setAttribute("logged_user", user);
        	return true;
        } 
		return false;
    }
	
	public User getLoggedUser() throws NotLoggedException {
        User user = (User) session.getAttribute("logged_user");
        if (user == null) {
        	 throw new NotLoggedException(ErrorMessage.ERROR_DEFAULT);
        }
        return user;
    }
	
	public boolean isLogged() {
        User user = (User) session.getAttribute("logged_user");
        if (user == null) {
            return false;
        }
        return true;
    }
	
	public void logout() throws NotLoggedException{
        User user = (User) session.getAttribute("logged_user");
        if (user == null) {
        	throw new NotLoggedException(ErrorMessage.ERROR_DEFAULT);
        }
        this.updateUser(user);
        session.removeAttribute("logged_user");
        session.invalidate(); 
    }
	
	private void updateUser(User user) {
        try {
            session.setAttribute("logged_user", user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

