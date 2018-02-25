<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.codingredefined.movie.business.model.Movie" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Movie List</p>
<% ArrayList<Movie> movieList = (ArrayList)request.getAttribute("movieList"); %>
<p>Total Movies: <%= movieList.size() %></p>
<table border="1">
	<tr>
		<th>Movie</th>
		<th>Genre</th>
		<th>Release Year</th>
		<th>Rating</th>
		<th>Downloaded</th>
		<th>Watched</th>
		<th>PG</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<% for(Movie movie : movieList) { 
		String genre = null;
		String toBeWatched = null;
		String watched = null;
		String pg = null;
		
		genre = movie.getGenre1();
		if(movie.getGenre2() != null && !movie.getGenre2().equals("null")) {
			genre += " " + movie.getGenre2();
		}
		if(movie.getGenre3() != null && !movie.getGenre3().equals("null")) {
			genre += " " + movie.getGenre3();
		}
		
		if(movie.getToBeWatched() != null) {
			toBeWatched = "Yes";
		} else {
			toBeWatched = "No";
		}
		
		if(movie.getWatched() != null) {
			watched = "Yes";
		} else {
			watched = "No";
		}
		
		if(movie.getPg() == 1) {
			pg = "Yes";
		} else {
			pg = "No";
		}
		
	%>
	<tr>
		<td><%= movie.getMovieName() %></td>
		<td><%= genre %></td>
		<td><%= movie.getReleaseYear() %></td>
		<td><%= movie.getRating() %></td>
		<td><%= toBeWatched %></td>
		<td><%= watched %></td>
		<td><%= pg %></td>
		<td><a href="update/<%=movie.getMovieId() %>" onclick="return confirm('Do you want to update?')" >Update</a></td>
		<td><a href="delete/<%=movie.getMovieId() %>" onclick="return confirm('Do you want to delete?')" >Delete</a></td>
	</tr>
	<% } %>
</table>
</body>
</html>