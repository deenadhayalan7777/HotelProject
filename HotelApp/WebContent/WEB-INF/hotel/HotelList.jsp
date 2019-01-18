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
<h4 align="left" style="color:green"> <s:property value=" #session.hotel.username"/></h4> 
 
  
  <form action="HotelAction" method="post" align="center">
  <br>Select any one of the Hotel below<br>
  <div class="row">
  <div align="center" class="column">
  <table border="1" cellpadding="5">
   <s:iterator value="hotels" >  
			<tr>
			<td> <button name="option" type="submit" value=hotelId ><s:property value="username"/></button></td>
			<td><s:property value="rating"/></td>  
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