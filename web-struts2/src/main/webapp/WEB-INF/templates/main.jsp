<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title><decorator:title default="Página desconocida" /></title>
	
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
	
	<!-- Fuente con multiples iconos: http://fortawesome.github.io/Font-Awesome/icons/-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="http://cdn.jsdelivr.net/flag-icon-css/0.6.0/css/flag-icon.min.css">
	
	<link rel="stylesheet" href="<s:url  value="/resources/css/app.css" />">
	
	<decorator:head/>
</head>
<body>
	
	<jsp:include page="navbar.jsp" />
	
	<div class="content">
	
		<div class="container-fluid">
		
			<jsp:include page="messages.jsp" />
			
		</div>
		
		<div class="container-fluid">
			<decorator:body />
		</div>
		
	</div>
	
	<%-- Scripts en el final del body para no parar la carga de la pagina --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<decorator:getProperty property="page.footerScripts"/>
</body>
</html>