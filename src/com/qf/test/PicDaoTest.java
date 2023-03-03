package com.qf.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qf.dao.PicDao;
import com.qf.entity.Pic;


public class PicDaoTest {

	@Test
	public void testAdd() throws Exception{
		PicDao dao = new PicDao();
		Pic pic = new Pic();
		pic.setId(1);
		pic.setPicName("zz");
		pic.setUserId(1);
		dao.add("zz", 1);
	}
	@Test
	public void testFindByUserId() throws Exception {
		PicDao dao = new PicDao();
		List<Pic> pics = dao.findByUserId(1);
		System.out.println(pics);
	}

}
