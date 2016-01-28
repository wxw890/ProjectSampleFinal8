package com.hta.member.repository;
//로그인을 위한 dto이다.
public class LoginCommand {
	private String email;
	private String password;
	private boolean rememberEmail;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberEmail() {//boolean의 true, flase의 값을 보여줄 get이라 생각하면될듯...
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	
}
