package com.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
   @Column(name="name")
	String name;
   @Column(name="private_password")
	String privatePassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivatePassword() {
		return privatePassword;
	}
	public void setPrivatePassword(String privatePassword) {
		this.privatePassword = privatePassword;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", privatePassword=" + privatePassword + "]";
	}
	
	
	
}
