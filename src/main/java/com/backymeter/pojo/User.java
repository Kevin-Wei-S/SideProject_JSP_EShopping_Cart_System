package com.backymeter.pojo;

public class User {
	
	private Integer id;
	private String account;
	private String userName;
	private String email;
	private String password;
	private String phone;
	private String salt;
	private String gender;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		
		return  "User{" +
				"id=" + id +
				", account='" + account + '\'' +
				", userName='" + userName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", salt='" + salt + '\'' +
				", gender='" + gender +'\'' + '}';
				
	}
	
	public User(){
		
	}
	
	public User(Integer id, String account, String userName, 
				String email, String password, String phone, String salt, String gender) {
		
		this.id = id;
		this.account = account;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.salt = salt;
		this.gender = gender;
		
	}
	
}
