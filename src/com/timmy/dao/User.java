package com.timmy.dao;

import java.util.HashSet;
import java.util.Set;


public class User {
        private String username;
        private String password;
        private String telephone;
        private String Email;
        private String userNumber;
        private String sex;
        
	
		
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getUserNumber() {
			return userNumber;
		}
		public void setUserNumber(String userNumber) {
			this.userNumber = userNumber;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
	
        
        
}
