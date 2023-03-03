package com.qf.test;

import static org.junit.Assert.*;

import java.awt.image.DataBufferUShort;
import java.util.List;

import org.junit.Test;
import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.util.DButil;

/**
 * junit 单元测试 
 * 对要进行测试的类右键new-->other-->java--->junit--->junit test case*/
public class UserDAOTest {

	@Test
	public void testFind() throws Exception {
		UserDao dao = new UserDao();
		List<User> users = dao.find();
		System.out.println(users);
	}
	
	@Test
	public void testFindByUsername() throws Exception{
		UserDao dao = new UserDao();
		User user = dao.findByUsername("tom");
		System.out.println(user);
	}
	@Test
	public void testDBUtil() throws Exception{
		System.out.println(DButil.getConnection());
	}
	@Test
	public void testFindById() throws Exception{
		UserDao dao = new UserDao();
		User user = dao.findById(9);
		System.out.println(user);
	}
	
	
}
