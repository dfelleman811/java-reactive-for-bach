package com.revature.models;

import java.util.Objects;

public class User {
	
	private Integer id;
	private String username;
	private String password;
	private double age;
	private Role role;
	
	public User() {
		super();
	}

	public User(Integer id, String username, String password, double age, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
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
	
	public double getAge() {
		return age;
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, id, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Double.doubleToLongBits(age) == Double.doubleToLongBits(other.age) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", role="
				+ role + "]";
	}

	
	
}
