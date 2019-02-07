<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<div class="p-3 mb-2 bg-light text-danger text-center">Current Orders in Hotel</div>
<s:if test="%{myOrders.size()==0}">
	         No Orders
</s:if>
 <s:else>
<div class="container" id="ordercontainer">
 <table border="0" cellpadding="20">
            <tr>
                <th>PHONE NO</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>RATING</th>
            </tr>
            <s:iterator value="myOrders">  
			<tr>
			<td><s:property value="phoneNo"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td>  
			<td>
			<s:if test="%{rating==0}">
	         <span class="badge badge-secondary ">NOT RATED</span>
            </s:if>
            <s:else>
			<s:property value="rating"/>
			</s:else></td> 
			</tr>   
			</s:iterator>
 </table>
</div> 
</s:else>       
</body>
</html>