<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/HotelApp/user/RateOrder.js"></script>
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
            <s:iterator value="currentOrders" status="status">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td><s:property value="status"/></td>  
			<td><input name="rate" class="rate" type="text" >Rating</input></td>
			<td> <button onclick="rateOrder('<s:property value="orderId"/>','<s:property value="%{#status.count}" />')">RATE ORDER</button></td>
			</tr>   
			</s:iterator>
 </table>
 
<s:form name="myForm" action="rateorderaction"   method="post" >
<s:hidden name="rating" id="rating" value='0' />
<s:hidden name="orderId" id="orderId" value='0'/>
</s:form>

</body>
</html>