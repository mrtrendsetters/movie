<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>webapp</title>
</head>
<body>
Welcome, <%= request.getSession().getAttribute("user_name") %>! <br />
<a href="genre/add">Add Genre</a><br />
<a href="genre/viewAll">View Genre List</a><br />
<a href="movie/viewAll">View Movie List</a><br />
<a href="movie/add">Add Movie</a><br />
</body>
</html>