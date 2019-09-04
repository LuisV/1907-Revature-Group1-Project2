package com.revature.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
	@SequenceGenerator(name="login", sequenceName="user_seq", allocationSize=1)
	private Integer id;
	private String username;
	private String password;
	private Integer role;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="player_items",
			   joinColumns=@JoinColumn(name="player_id"),
		       inverseJoinColumns=@JoinColumn(name="item_id"))
	private List<Item> items;

	public User() {
		super();
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public User(Integer id, String username, String password, Integer role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
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

	public Integer getRole()
	{
		return role;
	}

	public void setRole(Integer role)
	{
		this.role = role;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		return role != null ? role.equals(user.role) : user.role == null;
	}

	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
