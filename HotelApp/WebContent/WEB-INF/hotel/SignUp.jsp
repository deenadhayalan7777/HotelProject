<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOTEL SIGNUP</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
<h1 align="center">HOTEL SIGNUP</h1>

  <div class="container" align="center">
  <s:form name="myform" action ="signupaction" validate="true"  method="post">
    <div class="form-group">
	<s:textfield name ="username" cssClass="form-control" placeholder="username"/>
	</div>
	<div class="form-group">
	<s:password name ="password" cssClass="form-control" placeholder ="Password"/>
	</div>
	<div class="form-group">
	<s:password name ="phone" cssClass="form-control" placeholder ="Phone"/>
	</div>
	 <div class="form-group" >
	 <select name="id" >
	 <c:set var="id" value="1" scope="page" />
     <s:iterator value="#session.locations" status="stat">
     <option value="${id}"><s:property /></option>
      <c:set var="id" value="${id + 1}" scope="page"/>
      </s:iterator>      
      </select>
	 </div>
	<s:submit value="SIGNUP" onclick="" cssClass="btn btn-success btn-md" align="center"/>
	
	</s:form >
		  
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