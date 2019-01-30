<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<script src="/HotelApp/user/user.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body onload="test('<s:property value ="hotels.size()"/>')" >

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.user.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="myorders">MyOrders</a>
      </li>
     
      
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <s:property value="#session.location"/> 
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li> 
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>
<div class="container" id="hotelcontainer">
 <c:set var="count" value="0" scope="page" />
<form action="selecthotelaction" method="get" align="center">
  <div class="row">
  <div align="center" class="column">
  <table border="0" cellpadding="20">
   <s:iterator value="hotels" >  
			<tr>
			<td><s:property value="username"/></td> 
			<td><s:property value="rating"/></td>  
			<td><button class="btn btn-outline-info viewbtn" name="sno" type="submit" value="${count }">OPEN</button></td>
			<c:set var="count" value="${count + 1}" scope="page"/>
			<td class="status"><s:property value="status"/></td> 
			</tr>  
  </s:iterator> 
  </table>
  </div>
  </div>
</form>
</div>

<s:form action="location" method="post">
<s:hidden name="userId"><s:property value=" #session.user.userId"/></s:hidden>
<s:select label="Location" 
		headerKey="-1" headerValue="%{#session.location}"
		list="#session.locations" 
		name="locations" />
<s:submit value="submit" name="submit" />		
</s:form>

<s:iterator value="#session.locations" status="stat">
<s:hidden id="id%{#stat.index}" name="id" value="%{locationId}"></s:hidden>
<s:hidden id="name%{stat.index}" name="id" ><s:property value="%{name}"/></s:hidden>
</s:iterator>

<s:if test="hasActionErrors()">
   
     <div class="alert alert-danger">
  	<strong>Error!</strong><s:actionerror/>
	</div> 
   
</s:if>

<s:if test="hasActionMessages()">
   <div class="alert alert-success">
     <strong>Success!</strong> <s:actionmessage/>
   </div>
</s:if>
</body>
</html>