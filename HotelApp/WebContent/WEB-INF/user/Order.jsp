<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
<script src="/HotelApp/user/Order7.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body onload="test('<s:property value ="menu.size()"/>')" >

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
      
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>


  
  
  <br>Hotel Menu<br>
  <table id="mytable" border="0" cellpadding="20">
   <s:iterator  value="menu" status="status">  
			<tr>
			<td><s:property value="name"/></td>  
			<td><s:property value="price"/></td> 
			<td><button type="button" class="btn btn-outline-success" onclick="removeItem('<s:property value="itemId"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="%{#status.count}" />','1')">-</button>   <span class="badge badge-success quantity">ADD</span>  <button type="button" class="btn btn-outline-success" onclick="addItem('<s:property value="itemId"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="%{#status.count}" />','1')">+</button></td>
			<td><s:property value="stock"/></td> 
			</tr>  
  </s:iterator> 
  </table>
  
  <p id="box" > </p>
<s:form name="myForm" action="orderaction"   method="post" >

<s:hidden name="itemslist" id="itemslist" value="items" />
<s:hidden name="total" id="total" value='0' />
<s:hidden name="hotelId" id="hotelId" value='0'/>
 <input  type="button" onclick="makeOrder('<s:property value="#session.hdetail.hotelId"/> ')"  value="MAKE ORDER"/>
</s:form>
 
<br><br><br>
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