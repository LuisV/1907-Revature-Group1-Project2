package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="login")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
	@SequenceGenerator(name="login", sequenceName="login_seq", allocationSize=1)
	private Integer id;
	
	private String username;
	private String password;
	
	
	public User() {
		super();
	}
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
