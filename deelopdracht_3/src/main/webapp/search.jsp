<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css">
    <title>Search Page</title>
    <script src="js/search.js"></script>
</head>
<body>
<header>
    <h1>Contact Tracing @Campus Proximus</h1>
    <p><a href="index.jsp">home</a></p>
    <p><a href="search.jsp">search</a></p>
    <p><a href="SignUp.jsp">Sign Up</a></p>
    <p><a href="covid-19.jsp">covid-19</a></p>
    <p><a href="roomcount.jsp">roomcount</a></p>
    <c:choose>
        <c:when test="${not empty user}">
            <p><a href="friends.jsp">friends</a> </p>
        </c:when>
    </c:choose>
</header>

<h2>Search Page</h2>

<form>
    <label for="Date">Date:</label>
    <input type="text" id="Date" name="Date"><br>

    <label for="Room">Room:</label>
    <input type="text" id="Room" name="Room"><br>

    <input type="button" value="button" onclick="searchPersons()">
</form>

<div class="flex-container">
    <table>
    <thead>
    <th>First name</th>
    <th>Last name</th>
    <th>Date</th>
    <th>Room</th>
    <th>Email</th>
    <th>GSM</th>
    </thead>
    <tbody id="tbody">
    <tr>
    </tr>
    </tbody>
</table>
</div>

</body>
</html>
