<%@page import="java.util.List"%>
<%@page import="com.qf.entity.Pic"%>
<%@page import="com.qf.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>列表详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						User Detail:
					</h1>
					<table class="table">
						<tr>
							<td>
								姓名
							</td>
							<td>
								电话
							</td>
						</tr>
						<% User user=(User)request.getAttribute("user");%>
						<tr>
							<td>
								<%=user.getName()%>
							</td>
							<td>
								<%=user.getPhone()%>
							</td>
						</tr>
					</table>
					<h1>
						Load Photo:
					</h1>
						<%
			               User user2=(User)session.getAttribute("user");
			               if (user2!=null){
			                   if (user2.getId()==user.getId()){
			            %>
			            <!-- 文件上传 -->
						<form action="upload" method="post" enctype="multipart/form-data">
							
							Upload File Name:
							<input type="file" name="file1" />
							<input type="submit" value="confirm" />
						</form>
						<%
			                   }
						%>
					<h1>
						view photo:
					</h1>
					<table>
						 <%
		                    List<Pic> pics = (List<Pic>)request.getAttribute("pics");
						 	for(Pic pic : pics){
		                 %>
								<tr>
									<td>
										<img src="<%=pic.getPicName()%>" width="300"
											height="200" />
									</td>
								</tr>
								<%
				                    }
				                %>
					</table>
					<% } %>
				</div>
				<a href="list">return</a>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
