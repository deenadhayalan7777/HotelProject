<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>User Login</title>
</head>
<body>
<h1 align="center">USER LOGIN</h1>

  <div class="container" align="center">
  <s:form action ="UserLoginAction" validate="true">
    <div class="form-group">
	<s:textfield name ="username" cssClass="form-control" placeholder="username"/>
	</div>
	<div class="form-group">
	<s:password name ="password" cssClass="form-control" placeholder ="Password:"/>
	</div>
	<s:submit value="login" cssClass="btn btn-success btn-md" align="center"/>
	
	</s:form >
	
	<p >New User? <a href="UserSignUp">Sign Up Here</a></p>
	  
  </div>




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