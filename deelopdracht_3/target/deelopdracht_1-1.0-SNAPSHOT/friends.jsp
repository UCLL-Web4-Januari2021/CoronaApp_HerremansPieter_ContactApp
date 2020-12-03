<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Friends</title>
    <link rel="stylesheet" href="styles.css">
    <script src="js/Friends.js"></script>
</head>
<body>
<header>
    <h1>Contact Tracing @Campus Proximus</h1>
    <p><a href="index.jsp">home</a></p>
    <p><a href="search.jsp">search</a></p>
    <p><a href="SignUp.jsp">Sign Up</a></p>
    <p><a href="covid-19.jsp">covid-19</a></p>
    <c:choose>
        <c:when test="${not empty user}">
            <p><a href="friends.jsp">friends</a> </p>
        </c:when>
    </c:choose>
</header>
<H1>Friends</H1>
<form action="Controller?command=AddFriend" method="post">
    <label for="email">Email:</label>
    <input type="text" id="email" name="email">
    <br>

    <input type="submit" value="add friend">
</form>

<!-- friend list -->


<table>
    <thead>
        <th><h2>Friends</h2></th>
    </thead>
    <tbody id="tbody">
    <tr>
        <td>dummy</td>
    </tr>
    </tbody>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>
