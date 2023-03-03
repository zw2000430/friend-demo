package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.dao.PicDao;
import com.qf.dao.UserDao;
import com.qf.entity.Pic;
import com.qf.entity.User;
/**用户详情列表*/
public class userDetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获得请求参数id
		Integer id = Integer.parseInt(request.getParameter("id"));
		//查询数据库
		UserDao dao = new UserDao();
		PicDao picDao= new PicDao();
		User user = dao.findById(id);
		List<Pic> pic = picDao.findByUserId(id);
		//转发
		request.setAttribute("pics", pic);
		request.setAttribute("user", user);
//		System.out.println(user);
		request.getRequestDispatcher("userDetail.jsp").forward(request, response);
		
	}
}
