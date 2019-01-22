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
 <table border="0" cellpadding="20">
            <tr>
                <th>HOTEL NAME</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>RATING</th>
            </tr>
            <s:iterator value="myOrders">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td><s:property value="status"/></td>  
			<td><s:property value="rating"/></td> 
			</tr>   
			</s:iterator>
        </table>
</body>
</html>