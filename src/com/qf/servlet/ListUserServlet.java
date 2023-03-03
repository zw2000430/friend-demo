package com.qf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.User;
import com.qf.dao.UserDao;;
/**
 * 查询数据库，将所有用户信息查询出来
 * */
public class ListUserServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * 使用DAO查询数据库，将所有员工信息查询出来
		 * */
		try {
			UserDao dao = new UserDao();
			List<User> user = dao.find();
			
			/*
			 * 使用转发，将处理转交给userList.jsp
			 * 
			 * */
			//1.绑定数据
			request.setAttribute("userlist", user);
			//2.获得转发器
			RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
			//3.转发
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
//			request.setAttribute("error_msg", "系统繁忙，请稍后重试");
//			request.getRequestDispatcher("error.jsp").forward(request, response);
			//将异常抛给容器
			throw new ServletException(e);
		}		
	}

}
