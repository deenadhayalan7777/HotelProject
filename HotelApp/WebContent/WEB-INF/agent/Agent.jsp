<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agent</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="/HotelApp/agent/Agent3.js"></script>

</head>
<body onload = "test('<s:property value ="currentOrders.size()"/>','<s:property value ="hotels.size()"/>')" >
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.agent.username"/></a>
 
  
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
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>
<p>Deliver your orders now</p>
<div id="ordercontainer" class="container">
 <c:set var="count" value="0" scope="page" />
<form action="deliveryaction" method="post" align="center">
 <table border="0" cellpadding="20">
            <tr>
                <th>HOTEL NAME</th>
                <th>USER PHONE</th>
                <th>TOTAL</th>
                <th>DATE</th>
            </tr>
            <s:iterator value="currentOrders">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="phoneNo"/></td>  
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td class="deliverbtn"><button class="btn btn-outline-primary" name="sno" type="submit" value="${count }">DELIVER</button></td>
			 <c:set var="count" value="${count + 1}" scope="page"/>
			  <td class="timer" ><s:property value="timer"/></td>  
			</tr>   
			</s:iterator>
        </table>
</form>    
</div>
<p>Pick Up Orders from below hotels<p>
<div id="hotelcontainer" class="container">
  <c:set var="count" value="0" scope="page" />
  <form action="selecthotelaction" method="get" align="center">
  <br>Select any one of the Hotel below<br>
  <div class="row">
  <div align="center" class="column">
  <table border="0" cellpadding="20">
   <s:iterator value="hotels" >  
			<tr>
			<td><s:property value="username"/></td>
			<td><s:property value="rating"/></td>  
			<td><button class="btn btn-outline-info pickupbtn" name="sno" type="submit" value="${count }">PICKUP</button></td>
			<c:set var="count" value="${count + 1}" scope="page"/>
			<td class="status" ><s:property value="status"/></td>  
			</tr>  
  </s:iterator> 
  </table>
  </div>
  </div>
  
</form>
</div>

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