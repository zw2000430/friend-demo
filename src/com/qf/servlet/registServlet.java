package com.qf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.qf.dao.UserDao;
import com.qf.entity.User;

public class registServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    //读取注册信息
		String username=request.getParameter("username");
	    String name=request.getParameter("name");
	    String pwd=request.getParameter("pwd");
	    Integer age=Integer.parseInt(request.getParameter("age"));
	    String gender=request.getParameter("gender");
	    String phone=request.getParameter("phone");
	    /*
		 * 在服务器端，通常需要对请求参数值做检查
		 * 比如，检查name是否为null或者空字符串，
		 * */
	    UserDao dao=new UserDao();
		try {
			if(dao.findByUsername(username)==null) {
			    User user = new User();
			    user.setUsername(username);
			    user.setName(name);
			    user.setPwd(pwd);
			    user.setAge(age);
			    user.setGender(gender);
			    user.setPhone(phone);
			    dao.regist(user);
			    /**
			     * 比较验证码*/
			    //1.用户提交的验证码
			    String num = request.getParameter("checkcode");
			    //2.获取绑定到session中的验证码
			    String check = (String) request.getSession().getAttribute("number");
			    //equalsIgnoreCase()验证码不区分大小写
			    if (check.equalsIgnoreCase(num)) {
			    	String msg="注册成功，请登录！";
			    	//用JAVA GUI来进行跳转提示
			    	JOptionPane.showMessageDialog(null,msg);
			        response.sendRedirect("login.jsp");
			    } else {
			    	//验证码不匹配，提示用户
			    	request.setAttribute("number_error", "验证码错误");
			        request.getRequestDispatcher("regist.jsp").forward(request, response);
			    }
			}else {
				//用户名已存在
		    	request.setAttribute("username_error", "用户名已存在,请更换用户名");
		    	request.getRequestDispatcher("regist.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 	
}
