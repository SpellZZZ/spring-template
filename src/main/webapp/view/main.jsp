<%@page import="com.example.demo.controller.webController"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.GameData"%>
<%@page import="com.example.demo.dao.GameDataRepo"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.Optional"%>
<%@page import="com.example.demo.security.SpringSecurityConfig"%>
<%@page import="com.example.demo.security.MyUserPrincipal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta http-equiv="Refresh" content="5">	<!--     reload!     -->



<script type="text/javascript" src="../view/js/js.js"></script>
<script>
generateGameList();
</script>





<title>Main</title>
</head>
<body>

<header>
<%
	Optional<String> username = SpringSecurityConfig.getCurrentUserLogin(); 
%>

Hello <%out.print(" " + username.get()); %>!
</header>


<p id="createGame"><button onclick="gameCreator()"> Create Game </button> </p>

 <p><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></p>


<p></p>
<p></p>
<h3>Active games</h3>
<div id= "games"></div>


	
 
</body>
</html>