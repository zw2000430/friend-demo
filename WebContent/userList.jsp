<%@page import="com.qf.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>用户列表</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">Main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Username
							</td>
							<td>
								Gendar
							</td>
							<td>
								Age
							</td>
							<td>

							</td>
						</tr>
						<%
							List<User> user = (List<User>)request.getAttribute("userlist");
							for(int i = 0;i <user.size();i++){
								User e = user.get(i);
							%>
						<!-- 奇数为row2样式 偶数为row1样式 -->
								<tr class="row<%= (i % 2 + 1)%>">
									<td><%=e.getId() %></td>
									<td><%=e.getUsername() %></td>
									<td><%=e.getGender() %></td>
									<td><%=e.getAge() %></td>
									<td>
										<a href="detail?id=<%=e.getId() %>">详细</a>
										
									</td>
								</tr>
							<% 
							}
						%>
							

					</table>
					<p>
						<input type="button" class="button" value="退出系统"
							onclick="location='login.jsp'" />
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
