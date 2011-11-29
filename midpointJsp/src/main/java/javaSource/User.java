package javaSource;

public class User {
	private String userName = "admin";
	private String userPass = "admin";
	public String userFirstName = "Janko";
	public String userLastName = "Hraško";
	public String userNickName = "Janèi";
	public String userBirthDate = "15/12/1985";
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	

}
