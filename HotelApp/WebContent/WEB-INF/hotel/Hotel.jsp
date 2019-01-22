<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<script type="text/javascript">
function test(status){
	 var x = parseInt(status);
	 if(x==1)
	 document.getElementById("status").innerHTML ="CLOSE";
	 else
		document.getElementById("status").innerHTML="OPEN"; 
	}
</script>
</head>
<body onload = "test('<s:property value="#session.hotel.status"/>')">
<h4 align="left" style="color:green">Welcome <s:property value=" #session.hotel.username"/></h4> 
 
  
  <form action="hotelaction" method="get" align="center">
  <br>choose any of the option below<br>
  <div class="row">
  <div align="center" class="column">
  <br><button name="option" type="submit" value=1>ADD MENU ITEM</button></br>
  <br><button name="option" type="submit" value=2>LIST ORDERS</button></br>
  <br><button name="option" type="submit" value=3>DISCOUNT</button></br>
  <br><button id="status" name="option" type="submit" value=4 >OPEN/CLOSE</button></br>
   <br><button name="option" type="submit" value=5>LOGOUT</button></br>
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