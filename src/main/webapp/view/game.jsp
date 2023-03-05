<%@page import="com.example.demo.model.GameData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">




<script>

window.onload = function () {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    
    for (var i = 0, l = params.length; i < l; i++) {
         tmp = params[i].split('=');
         data[tmp[0]] = tmp[1];
    }
     
 	
     fetch('../def/getGame?id='+data.id+'')
	  .then(response => response.json())
	  .then(item => {
		
		if(item != null) {
			
			const tempID = item.id
			const tempName1 = item.firstPlayer
			const tempName2 = item.secondPlayer
			
			document.getElementById("header").innerHTML += "<p>Game: "+ tempName1 + " and " + tempName2 + "</p>";

		}
			
			
		})
	  .catch(error => {
	    console.error('blad pobierania danych:', error);
	  });
     
     
}

</script>







<title>Insert title here</title>
</head>
<body>


<header id ="header"></header>



</body>
</html>