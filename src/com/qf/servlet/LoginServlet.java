package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.dao.UserDao;
import com.qf.entity.User;



public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//读取用户名和密码
		String username  = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		/*
		 * 在服务器端，通常需要对请求参数值做检查
		 * 检查name是否为null或者空字符串，暂时不做
		 * */
		
		//访问数据库，查看数据库当中有没有匹配的记录
		UserDao dao = new UserDao();
		try {
			User user = dao.findByUsername(username);
			/*若用户为空，则登录失败
			 *若用户不为空，则判断密码是否一致
			 * */
			if(user != null && user.getPwd().equals(pwd)){
				//登录成功，跳转到主功能页面
				/* 进行session验证
				 * 1.在session对象上绑定数据
				 * 2.对于需要登录之后才能访问的组件，添加session验证代码(jsp)
				 * */
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("list");
				
			}else{
				//登录失败，跳转到登录页面并提示用户
				request.setAttribute("login_error", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			//让容器来处理系统异常
			throw new ServletException(e);
		}
	}
}
