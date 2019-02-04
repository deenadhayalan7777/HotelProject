<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/HotelApp/user/MyOrders2.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body onload="test('<s:property value ="currentOrders.size()"/>','<s:property value ="myOrders.size()"/>')" >
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.user.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
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

<div class="container border border-danger" >

 <table id="mytable" class="table table-hover">
            <tr>
                <th>HOTEL NAME</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>EST TIME</th>
            </tr>
            <s:iterator value="currentOrders" status="stat">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td class="status" ><s:property  value="status"/></td> 
			<td > <span class="badge badge-warning"><s:property  value="timer"/></span></td> 
			<td class="timer" ><s:property  value="timer"/></td> 
			<td class="track"><button  type="button" class="btn btn-outline-warning" onclick="trackOrder('<s:property value="orderId"/>','<s:property value="%{#stat.index}" />')"> TRACK ORDER </button></td>
			</tr>   
			</s:iterator>
</table>

</div>

<div class="container border border-light">
 <table id="mytable" class="table table-hover">
           
            <s:iterator value="myOrders" status="stat">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td class="rating1"><s:property  value="rating"/></td> 
			<td class="ratebtn"><button  type="button" class="btn btn-outline-success" onclick="rateOrder('<s:property value="orderId"/>','<s:property value="%{#stat.index}" />')"> RATE </button></td>
			<td class="status1"><s:property  value="status"/></td> 
			</tr>   
			</s:iterator>
</table>
 <s:form name="myForm" action="rateorderaction"   method="post" >
<s:hidden name="rating" id="rating" value='0' />
<s:hidden name="orderId" id="orderId" value='0'/>
</s:form>

<s:form name="myForm" action="map"   method="get" >
<s:hidden name="orderId" id="orderId1" value='0'/>
</s:form>
</div>

 
</body>
</html>