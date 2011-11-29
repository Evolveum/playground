package javaSource;

import javaSource.errors.ErrorMessage;
import javaSource.managers.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Midpoint {
	public Object login(HttpServletRequest request, HttpServletResponse response) {
		Object object = null;
		UserManager um = new UserManager(request.getSession(true));
		try {
			String loginName = request.getParameter("login_name");
			String loginPassword = request.getParameter("login_password");
			if (um.login(loginName, loginPassword)) {
				User user = um.getLoggedUser();
				object = user;
			} else {
				System.out.println("Error: wrong entries for login.");
				object = new javaSource.errors.Error(ErrorMessage.ERROR_DEFAULT, "wrong entries for login.");
			}
		} catch (Exception ex) {
			object = new javaSource.errors.Error(ErrorMessage.ERROR_DEFAULT);
			ex.printStackTrace();
		}
		return object;
	}
	
	public Object getLoggedUser(HttpServletRequest request, HttpServletResponse response) {
        Object object = (User) request.getSession().getAttribute("logged_user");
        if (object == null) {
            object = new javaSource.errors.Error(ErrorMessage.ERROR_DEFAULT, "user not logged.");
            System.out.println("Error: User not logged.");
        }
        return object;
    }
	
	public Object logout(HttpServletRequest request, HttpServletResponse response) {
        Object object = null;
        try {
            new UserManager(request.getSession()).logout();
        } catch (Exception ex) {
            object = new javaSource.errors.Error(ErrorMessage.ERROR_DEFAULT, "the user is already logged off");
            ex.printStackTrace();
        }
        return object;
    }
}
