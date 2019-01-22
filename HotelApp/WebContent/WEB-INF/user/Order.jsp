<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
<script src="/HotelApp/user/Order.js"></script>
</head>
<body>
<h4 align="left" style="color:green"> <s:property value=" #session.user.username"/></h4> 
 
  
  
  <br>Hotel Menu<br>
  <table border="0" cellpadding="20">
   <s:iterator  value="menu" status="status">  
			<tr>
			<td><s:property value="name"/></td>  
			<td><s:property value="price"/></td> 
			<td><input name="quantity" class="quantity" type="text" >Quantity</input></td>
			<td> <button onclick="addItem('<s:property value="itemId"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="%{#status.count}" />')">ADD</button></td>
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