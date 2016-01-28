package com.hta.member.repository;

import java.util.Date;

import com.hta.exception.IdPasswordNotMachingException;

public class Member {
	   private String member_email;       
	   private String member_name;        
	   private String member_phonenumber;  
	   private String member_password;     
	   private String member_address;      
	   private int rentallimit;
	   private int reslimit;
	   
	   
	public int getRentalimit() {
		return rentallimit;
	}



	public void setRentalimit(int rentalimit) {
		this.rentallimit = rentalimit;
	}



	public int getReslimit() {
		return reslimit;
	}



	public void setReslimit(int reslimit) {
		this.reslimit = reslimit;
	}



	public Member(){
		
	}
	


	public Member(String member_email, String member_name, String member_phonenumber, String member_password,
			String member_address, int rentalimit, int reslimit) {
		super();
		this.member_email = member_email;
		this.member_name = member_name;
		this.member_phonenumber = member_phonenumber;
		this.member_password = member_password;
		this.member_address = member_address;
		this.rentallimit = rentalimit;
		this.reslimit = reslimit;
	}

	


	public String getMember_email() {
		return member_email;
	}



	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}



	public String getMember_name() {
		return member_name;
	}



	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}



	public String getMember_phonenumber() {
		return member_phonenumber;
	}



	public void setMember_phonenumber(String member_phonenumber) {
		this.member_phonenumber = member_phonenumber;
	}



	public String getMember_password() {
		return member_password;
	}



	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}



	public String getMember_address() {
		return member_address;
	}



	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}



	public void changePassword(String oldPassword, String newPassword){
		
		if(!member_password.equals(oldPassword))//패스워드 일치 확인
		{
			throw new IdPasswordNotMachingException();
		}
		this.member_password = newPassword;
	}
	
	public boolean matchPassword(String password){ //실제 패스워드가 맞는 지 검사
		return this.member_password.equals(password);
	}
	
	
}
