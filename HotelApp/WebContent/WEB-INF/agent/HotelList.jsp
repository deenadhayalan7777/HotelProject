<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HotelList</title>
</head>
<body>
<h4 align="left" style="color:green"> <s:property value=" #session.user.username"/></h4> 
 
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
			<td><button name="sno" type="submit" value="${count }">PICKUP</button></td>
			<c:set var="count" value="${count + 1}" scope="page"/>
			</tr>  
  </s:iterator> 
  </table>
  </div>
  </div>
  
</form>
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