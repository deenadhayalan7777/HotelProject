<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotel</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<script src="/HotelApp/hotel/hotel1.js"></script>
</head>
<body onload = "test('<s:property value="#session.hotel.status"/>','<s:property value ="currentOrders.size()"/>')">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.hotel.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="menu">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="myorders">MyOrders</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="discount">Discount</a>
      </li>
      <li class="nav-item">
      <a href="#" id="Location" class="btn btn-outline-light my-2 my-sm-0"><s:property value=" #session.hotel.location.name"/></a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
    
    <li class="nav-item">
      <a href="status" id="status" class="btn btn-outline-success my-2 my-sm-0">OPEN</a>
      </li>
      
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>
<div class="container" id="ordercontainer">
<table border="0" cellpadding="20">
            <tr>
                <th>PHONE NO</th>
                <th>TOTAL</th>
                <th>DATE</th>
                
               
            </tr>
            <s:iterator value="currentOrders">  
			<tr>
			<td><s:property value="phoneNo"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td class="acceptbtn"><button  type="button" class="btn btn-outline-success acceptOrder" onclick="acceptOrder('<s:property value="orderId"/>')"> ACCEPT </button></td>
			<td class="timer"><s:property value="timer"/></td>  
			<td class="status"><s:property value="status"/></td>  
			</tr>   
			</s:iterator>
 </table>
 </div>
 <s:form name="myForm" action="orderacceptaction"   method="post" >
<s:hidden name="orderId" id="orderId" value='0'/>
</s:form>
 
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