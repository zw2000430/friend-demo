package com.qf.entity;
/**
 * User实体类，用于封装从数据库查询出来的记录
 * 与数据库中的属性保持一致，实现get和set方法
 * */
public class User {
	private int id;
	private String username;
	private String name;
	private String pwd;
	private int age;
	private String gender;
	private String phone;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String name, String pwd, int age, String gender, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", pwd=" + pwd + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}
}
