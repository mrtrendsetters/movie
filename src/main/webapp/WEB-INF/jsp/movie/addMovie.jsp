<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.codingredefined.movie.business.model.Genre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../js/checkDuplicateMovieAJAX.js" ></script>
</head>
<body>
<% ArrayList<Genre> genreList = (ArrayList<Genre>)request.getAttribute("genreList"); %>
<form action="addToDB" method="post">
<p>Movie Name: <input type="text" name="movieName" id="movieName" onkeyup="checkDuplicate(this.value, 'add', '')" required autofocus /><span id="dupMovie"></span></p>
<p>Genre: <select name="genre1" required>
			<option value="">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>"><%= genre.getGenre() %></option>
			<% } %>
		  </select>
		  <select name="genre2">
		  	<option value="null">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>"><%= genre.getGenre() %></option>
			<% } %>
		  </select>
		  <select name="genre3">
		  	<option value="null">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>"><%= genre.getGenre() %></option>
			<% } %>
		  </select>
</p>
<p>Release Year: <input type="text" name="releaseYear" required /></p>
<p>Rating: <input type="text" name="rating" required /></p>
<p>Status: <select name="status">
			  <option value="null">Select Status</option>
			  <option value="toBeDownloaded">To-Be Downloaded</option>
			  <option value="downloaded">Downloaded</option>
			  <option value="watched">Watched</option>
		   </select> 
</p>
<p>PG: <input type="radio" name="pg" value="1" />Yes  <input type="radio" name="pg" value="0" />No </p>
<p><input type="submit" id="submit" disabled /></p>
</form>
</body>
</html>