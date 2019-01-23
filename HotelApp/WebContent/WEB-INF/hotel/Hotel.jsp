<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" style="color:red;" href="#"><s:property value=" #session.hotel.username"/></a>
 
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="menu">CurrentOrders</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="myorders">MyOrders</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="discount">Discount</a>
      </li>
      
    </ul>
    <ul class="navbar-nav ml-auto">
    
    <li class="nav-item">
      <a href="logout" id="status" class="btn btn-outline-success my-2 my-sm-0">OPEN</a>
      </li>
      
      <li class="nav-item">
      <a href="logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
      </li>
    </ul>

  </div>
</nav>

<table border="0" cellpadding="20">
            <tr>
                <th>PHONE NO</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>RATING</th>
            </tr>
            <s:iterator value="currentOrders">  
			<tr>
			<td><s:property value="phoneNo"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td><s:property value="status"/></td>  
			<td><s:property value="rating"/></td> 
			</tr>   
			</s:iterator>
 </table>
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