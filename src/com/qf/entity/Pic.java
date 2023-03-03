package com.qf.entity;
/**
 * pic 实体类
 * 
 * */
public class Pic {
	private int id;
	private String picName;
	private int userId;
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
	 * @return the picName
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * @param picName the picName to set
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Pic [id=" + id + ", picName=" + picName + ", userId=" + userId + "]";
	}
}
