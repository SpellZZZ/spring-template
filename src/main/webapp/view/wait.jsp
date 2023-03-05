<%@page import="com.example.demo.model.GameData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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
			window.location.replace("../game?id="+data.id+"");
		}
			
			
		})
	  .catch(error => {
	    console.error('blad pobierania danych:', error);
	  });
     
     
}

</script>


<meta charset="ISO-8859-1">
<meta http-equiv="Refresh" content="5">	<!--     reload!     -->
<title>Insert title here</title>
</head>
<body>
wait





</body>
</html>