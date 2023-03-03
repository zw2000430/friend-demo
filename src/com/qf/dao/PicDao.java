package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.Pic;
import com.qf.util.DButil;

public class PicDao {
	/**添加、上传图片*/
	public void add(String picName,Integer userId){
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DButil.getConnection();
			stat = conn.prepareStatement("INSERT INTO t_friendpic(picName,userId) values(?,?)");
			//给参数赋值
			stat.setString(1, picName);
			stat.setInt(2, userId);
			stat.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			DButil.close(conn);
		}
	}
	
	/**查看照片*/
	public List<Pic> findByUserId(Integer id){
		List<Pic> pics = new ArrayList<Pic>();
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DButil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM t_friendpic WHERE userId=?");
			
			stat.setInt(1, id);
			ResultSet res = stat.executeQuery();
			while(res.next()){
				Pic pic = new Pic();
				pic.setId(id);
				pic.setPicName(res.getString("picName"));
				pic.setUserId(res.getInt("userId"));
				pics.add(pic);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return pics;
	}
}
