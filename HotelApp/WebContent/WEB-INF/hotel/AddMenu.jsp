<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
<script src="/HotelApp/hotel/AddMenu8.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body  onload="test('<s:property value ="menu.size()"/>')">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.hotel.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="menu">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="myorders">MyOrders</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="discount">Discount</a>
      </li>
      
    </ul>
    <ul class="navbar-nav ml-auto">
     <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>

<h4 align="left" style="color:green"> <s:property value=" #session.user.username"/></h4> 
 
  
  
  <br>Hotel Menu<br>
  <table id="mytable" border="0" cellpadding="20">
   <tr>
                <th>NAME</th>
                <th>PRICE</th>
                <th>PREPARATION TIME</th>
                <th>STOCK</th>
            </tr>
   <s:iterator  value="menu" status="stat">  
           
			<tr>
			<td class="name"><s:property value="name"/></td>  
			<td><s:property value="price"/></td>  
			<td><s:property value="time"/></td>
			
			<td><div class="btn-group" role="group" aria-label="Basic example">
            <button type="button" class="btn btn-success btn-sm on" onclick="changeStatus('<s:property value="itemId" />','<s:property value="stock" />','1')" >ON</button>
            <button type="button" class="btn btn-default btn-sm off" onclick="changeStatus('<s:property value="itemId" />','<s:property value="stock" />','0')" >OFF</button>
            </div>
            </td>
            <td><s:property value="stock"/></td>
			</tr>  
  </s:iterator> 
  </table>
  
  <input name="name" id="name" type="text" />
  <input name="price" id="price" type="text" />
  <input name="time" id="time" type="text" />
  <input name="buttonExecute" onclick="addItem()" type="button" value="ADD ITEM" />
  
  <p id="box" > </p>
  
<s:form name="myForm" action="addmenuaction"   method="post" >

<s:hidden name="itemslist" id="itemslist" value="items" />

</s:form>

 <s:form name="form1" action="changestockaction"   method="post" >

<s:hidden name="itemId" id="itemId" value="" />
<s:hidden name="stock" id="stock" value="" />
 
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