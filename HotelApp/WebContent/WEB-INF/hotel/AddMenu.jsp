<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order</title>
<script src="/HotelApp/hotel/AddMenu.js"></script>
</head>
<body>
<h4 align="left" style="color:green"> <s:property value=" #session.user.username"/></h4> 
 
  
  
  <br>Hotel Menu<br>
  <table border="0" cellpadding="20">
   <s:iterator  value="menu" >  
			<tr>
			<td><s:property value="name"/></td>  
			<td><s:property value="price"/></td>  
			</tr>  
  </s:iterator> 
  </table>
  
  <input name="name" id="name" type="text" />
  <input name="price" id="price" type="text" />
  <input name="buttonExecute" onclick="addItem()" type="button" value="ADD ITEM" />
  
  <p id="box" > </p>
  
<s:form name="myForm" action="addmenuaction"   method="post" >

<s:hidden name="itemslist" id="itemslist" value="items" />

 <input  type="button" onclick="addItems()"  value="ADD MENU ITEMS"/>
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