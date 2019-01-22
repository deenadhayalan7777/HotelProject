<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:set var="count" value="0" scope="page" />
<form action="deliveryaction" method="post" align="center">
 <table border="0" cellpadding="20">
            <tr>
                <th>HOTEL NAME</th>
                <th>USER PHONE</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>RATING</th>
            </tr>
            <s:iterator value="currentOrders">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="phoneNo"/></td>  
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td><s:property value="status"/></td>  
			<td><s:property value="rating"/></td> 
			<td><button name="sno" type="submit" value="${count }">DELIVER</button></td>
			 <c:set var="count" value="${count + 1}" scope="page"/>
			</tr>   
			</s:iterator>
        </table>
</form>        
</body>
</html>