<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
<script src="/HotelApp/agent/PickUp.js"></script>
</head>
<body>
<h4 align="left" style="color:green"> <s:property value=" #session.user.username"/></h4> 
 
  
  
  <br>Hotel Menu<br>
  <table border="0" cellpadding="20">
            <tr>
                <th>HOTEL NAME</th>
                <th>USER PHONE</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>RATING</th>
            </tr>
            <s:iterator value="orders">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="phoneNo"/></td>  
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td><s:property value="status"/></td>  
			<td><s:property value="rating"/></td> 
			<td> <button onclick="addOrder('<s:property value="orderId"/>')">ADD</button></td>
			</tr>   
			</s:iterator>
</table>
 

  
  <p id="box" > </p>
<s:form name="myForm" action="pickupaction"   method="post" >

<s:hidden name="orderslist" id="orderslist" value="orders" />

 <input  type="button" onclick="pickUpOrders()"  value="PICKUP ORDERS"/>
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