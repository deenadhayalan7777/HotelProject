<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1 align="center">HOTEL SIGNUP</h1>
  <s:form action ="signupaction" align="center" validate="true">
   
	<s:textfield name ="username" label="Username:"/>
	<s:password name ="password" label ="Password:"/>
	<s:textfield name="phone" label="Phone"/>
	<div class="form-group">
	<s:textfield name ="x" cssClass="form-control" placeholder="x"/>
	<s:textfield name ="y" cssClass="form-control" placeholder="y"/>
	</div>   
	<s:submit />
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