
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="../style/home-style.css" rel="stylesheet" type="text/css">
<style>
	*
	{
		margin: 0px auto;
		box-sizing: border-box;
	}
	body
	{
		background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%);
	}
	.top
	{
		width:1024px;
		margin-top:30px;
	}
	.mid
	{
		height:auto;
	}
	.midleft
	{
		font-family:Garmond;
		font-size:26px;
	}
	.midleft ul
	{
		display: flex;
		flex-direction: row;
		margin-right: 10px;
	}
	.midleft li
	{
		list-style:none;
		margin-top:10px;
		display: flex;
		flex-direction: row;
	}
	.midleft a
	{
		color:#fff;
		text-decoration: none;
	}
	.midright
	{
		margin-top: 70px;
		height:auto;
		padding-top:50px;
		padding-bottom:50px;
	}
	.footer
	{
		width:1024px;
		height:30px;
	}
	
	td,th
	{
		font-size: 20px;
		padding-right: 50px;
	}
	a
	{
		font-size: 17px;
		text-decoration: none;
		color: red;
		font-weight: bold;
		font-style: italic;
	}
	table
	{
		background-color: #30c4dc;
		padding: 40px;
		border-radius: 20px;
		border: outset;	
		margin-top: 100px;	
	}
	input
	{
		border-radius: 10px;
		padding: 4px;
		border: none;
		margin-bottom: 10px;
	}
	.btn
	{
		padding-top: 5px;
		padding-bottom: 5px;
		padding-left: 20px;
		padding-right: 20px;
		width: -webkit-fill-available;
		margin-top: 15px;
		margin-bottom:0px;
	}
	hr
	{
		border-top: 3px dashed #1b6ba3;
		border-bottom: 0px;
		margin-top: 10px;
	}
</style>
</head>
<body bgColor="lightPink">
	<div class="top">
		<center>
			<h2>MY TODO LIST</h2><hr/>
		</center>
	</div>
	<div class="midleft">
			<ul>
				<li><a href="/TODO/HomeServlet" style="color: blue">HOME</a></li>
				<li><a href="./insert.jsp">INSERT</a></li>
			</ul>
	</div>	
</body>
</html>