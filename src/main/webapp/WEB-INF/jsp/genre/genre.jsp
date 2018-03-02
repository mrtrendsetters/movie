<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.codingredefined.movie.business.model.Genre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Genre List <br />
<% List<Genre> genreList = (List)request.getAttribute("genreList"); %>
<%
	for(Genre genre : genreList) {
		%>
		<%=genre.getGenre() %> <a href="delete/<%=genre.getGenreId() %>"  onclick="return confirm('Do you want to delete?')" >Delete</a>
		<%
	}
%>
</body>
</html>