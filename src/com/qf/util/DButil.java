package com.qf.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



/**
 * Util层用来存放工具类（对于独立性很高的小功能或者重复性很高的代码片段）
 * DButil类创建jdbc工具包  
 * （封装处理对数据库的连接操作）
 * */
public class DButil {
	
	//数据库链接
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		
		try {
			//动态加载mysql驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/friend-demo?serverTimezone=UTC","root","123456");
		} catch (Exception e) {
			
			e.printStackTrace();
			//通知servlet抛异常
			throw e;
		}		
		return conn;
	}

	/**
	 * 数据库关闭
	 * */
	public static void close (Connection conn ){
		if(conn!=null){
		try {
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("释放资源失败！");
		}
	}
}
	
	//检查链接
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
}
