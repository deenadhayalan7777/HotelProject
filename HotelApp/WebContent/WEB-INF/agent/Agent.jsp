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
<script src="/HotelApp/agent/Agent.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

</head>
<body >

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.agent.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active" id="home">
        <a class="nav-link" href='javascript:;' onclick="home()">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item" id="my">
        <a class="nav-link" href='javascript:;' onclick="myorders()">MyOrders</a>
      </li>
     
      
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <s:property value="#session.agent.location.name"/> 
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <c:set var="id" value="1" scope="page" />
         <s:iterator value="#session.locations" status="stat">
          <button class="dropdown-item" onclick="loc(${id},'<s:property />')"><s:property /></button>
          <c:set var="id" value="${id + 1}" scope="page"/>
         </s:iterator>         
        </div>
      </li>
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>
<div id="tabdiv">
<p>Deliver your orders now</p>
<div id="ordercontainer" class="container">
<s:if test="%{currentOrders.size()==0}">
	         No Orders
</s:if>
 <s:else>
            <c:set var="count" value="0" scope="page" />

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
			<td class="deliverbtn">
			<s:if test="%{timer==0}">
	         <button class="btn btn-outline-primary" name="sno" onclick="deliver(${count})" >DELIVER</button>
             </s:if>
            <s:else>
            <span class="badge badge-warning "><s:property value="timer"/></span>
            </s:else>
			</td>
			 <c:set var="count" value="${count + 1}" scope="page"/>
			</tr>   
			</s:iterator>
        </table>
 </s:else>
 

</div>
<p>Pick Up Orders from below hotels<p>
<div id="hotelcontainer" class="container">
<s:if test="%{hotels.size()==0}">
	         No Orders
</s:if>
 <s:else>
  <c:set var="count" value="0" scope="page" />
  <br>Select any one of the Hotel below<br>
  <div class="row">
  <div align="center" class="column">
  <table border="0" cellpadding="20">
   <s:iterator value="hotels" var="hotel">  
			<tr>
			<td><s:property value="username"/></td>
			<td><s:property value="rating"/></td> 
			<td><s:if test="%{status==0}">
	         <button class="btn btn-outline-info pickupbtn"  disabled >CLOSED</button>   
             </s:if>
            <s:else>
            <button class="btn btn-outline-info pickupbtn" name="sno" onclick="pickup(${count})" >PICKUP</button>
            </s:else></td> 
			<c:set var="count" value="${count + 1}" scope="page"/>
			<td><div class="pick"></div> 
			</tr>  
  </s:iterator> 
  </table>
  </div>
  </div>
</s:else>  
</div>
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