<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.codingredefined.movie.business.model.Movie" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.codingredefined.movie.business.model.Genre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../../js/checkDuplicateMovieAJAX.js" ></script>
</head>
<body>
<% 
	Movie movie = (Movie)request.getAttribute("movie"); 
	ArrayList<Genre> genreList = (ArrayList<Genre>)request.getAttribute("genreList");	

	String genre1 = movie.getGenre1();
	String genre2 = movie.getGenre2();
	String genre3 = movie.getGenre3();
	
	String status = null;
	if(movie.getWatched() != null) {
		status = "watched";
	} else if(movie.getToBeWatched() != null) {
		status = "downloaded";
	} else if(movie.getToBeDownloaded() != null) {
		status = "toBeDownloaded";
	} else {
		status = null;
	}
	
	%>
	
<form action="../updateToDB" method="post">
<input type="hidden" name="movieId" value="<%=movie.getMovieId() %>" />
<p>Movie Name: <input type="text" name="movieName" id="movieName" value="<%= movie.getMovieName() %>" onkeyup="checkDuplicate(this.value, 'update')" /><span id="dupMovie"></span></p>
<p>Genre: <select name="genre1">
			<option value="null">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>" <% if(genre1.equalsIgnoreCase(genre.getGenre())){out.print("selected");} %> ><%= genre.getGenre() %></option>
			<% } %>
		  </select>
		  <select name="genre2">
		  	<option value="null">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>" <% if(genre2 != null && movie.getGenre2().equalsIgnoreCase(genre.getGenre())){out.print("selected");} %> ><%= genre.getGenre() %></option>
			<% } %>
		  </select>
		  <select name="genre3">
		  	<option value="null">Select Genre</option>
			<% for(Genre genre : genreList) { %>
				<option value="<%= genre.getGenre() %>" <% if(genre3 != null && movie.getGenre3().equalsIgnoreCase(genre.getGenre())){out.print("selected");} %> ><%= genre.getGenre() %></option>
			<% } %>
		  </select>
</p>
<p>Release Year: <input type="text" name="releaseYear" value="<%=movie.getReleaseYear() %>" /></p>
<p>Rating: <input type="text" name="rating" value="<%=movie.getRating() %>" /></p>
<p>Status: <select name="status">
			  <option value="null">Select Status</option>
			  <option value="toBeDownloaded" <% if(status != null && status.equalsIgnoreCase("toBeDownloaded")){out.print("selected");} %> >To-Be Downloaded</option>
			  <option value="downloaded" <% if(status != null && status.equalsIgnoreCase("downloaded")){out.print("selected");} %> >Downloaded</option>
			  <option value="watched" <% if(status != null && status.equalsIgnoreCase("watched")){out.print("selected");} %> >Watched</option>
		   </select> 
</p>
<p>PG: <input type="radio" name="pg" value="1" <% if(movie.getPg() == 1){out.print("checked");} %> />Yes  <input type="radio" name="pg" value="0" <% if(movie.getPg() == 0){out.print("checked");} %> />No </p>
<p><input type="submit" id="submit" /></p>
</form>
</body>
</html>