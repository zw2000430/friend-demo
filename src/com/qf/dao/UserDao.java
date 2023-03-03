package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.User;
import com.qf.util.DButil;


/**
 * dao层 做数据库读写 增删改查（接口是为了规范开发）
 * 
 * */
public class UserDao {

	/**
	 * 返回用户列表（显示所有已注册用户的信息）
	 * */
	public List<User> find() throws Exception{
		List<User> user = new ArrayList<User>();
		//访问数据库
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DButil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM t_frienduser");
			ResultSet res = stat.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String username = res.getString("username");
				String gender = res.getString("gender");
				int age = res.getInt("age");
				//为User赋值
				User e = new User();
				e.setId(id);
				e.setUsername(username);
				e.setGender(gender);
				e.setAge(age);
				user.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return user;
		
	}
	/**注册*/
	public void regist(User user) throws Exception{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			/*添加用户*/
			conn = DButil.getConnection();
			stat = conn.prepareStatement("INSERT INTO t_frienduser" + 
					"(username,name,pwd,age,gender,phone) VALUES(?,?,?,?,?,?)");
			//给参数赋值
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getName());
			stat.setString(3,user.getPwd());
			stat.setInt(4,user.getAge());
			stat.setString(5,user.getGender());
			stat.setString(6,user.getPhone());
			
			//更新数据库
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
        	DButil.close(conn);
		}
		
	}
	
	/**
	 * 根据用户名查询（注册，登录）
	 * */
	 public User findByUsername(String username) throws Exception{
	        Connection conn = null;
	        PreparedStatement stat = null;
	        User user = null;
	        try {
	        	conn=DButil.getConnection();
	            stat = conn.prepareStatement("select*from t_frienduser where username=?");
	            stat.setString(1,username);
	            //遍历结果集，做查询
	            ResultSet res=stat.executeQuery();
	            if (res.next()){
	                user=new User();
	                user.setId(res.getInt("id"));
	                user.setUsername(res.getString("username"));
	                user.setName(res.getString("name"));
	                user.setPwd(res.getString("pwd"));
	                user.setAge(res.getInt("age"));
	                user.setGender(res.getString("gender"));
	                user.setPhone(res.getString("phone"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	        	DButil.close(conn);
			}
	        
	        return user;
	    }
	 /**
	  * 根据用户id判断是否为本人（用户详情上传照片）*/
	 public User findById(Integer id){	 
		 Connection conn = null;
         PreparedStatement stat = null;
         User user = null;
         try {
			conn = DButil.getConnection();
			stat = conn.prepareStatement("select*from t_frienduser where id=?");
			stat.setInt(1, id);
			//遍历结果集，做查询
			ResultSet res = stat.executeQuery();
			if (res.next()){
                user=new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setName(res.getString("name"));
                user.setPwd(res.getString("pwd"));
                user.setAge(res.getInt("age"));
                user.setGender(res.getString("gender"));
                user.setPhone(res.getString("phone"));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
        	DButil.close(conn);
		}
		 return user;
	 }
}
