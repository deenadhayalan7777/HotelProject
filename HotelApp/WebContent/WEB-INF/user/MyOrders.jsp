<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

<s:if test="%{currentOrders.size()==0}">
	        
</s:if>
 <s:else>
<div class="container border border-danger" >

 <table id="mytable" class="table table-hover">
            <tr>
                <th>HOTEL NAME</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>STATUS</th>
                <th>EST TIME</th>
            </tr>
            <s:iterator value="currentOrders" status="stat">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td> 
			<s:if test="%{status==0}">
	         <td><span class="badge badge-secondary ">WAITING</span></td>
            </s:if>
            <s:elseif test="%{status==1}">
                 <s:if test="%{timer==0}">
	                <td><span class="badge badge-primary ">PREPARED, WAITING FOR AGENT</span></td>
                  </s:if>
                 <s:else>
			     	<td><span class="badge badge-warning ">PREPARING FOOD</span></td>
			     	<td><span class="badge badge-danger "><s:property value="timer"/></span></td>
                 </s:else> 
            </s:elseif>
			<s:else>
			   <td><span class="badge badge-success ">ASSIGNED</span></td>
			   <td><span class="badge badge-danger "><s:property value="timer"/></span></td>
			   <td class="track"><button  type="button" class="btn btn-outline-warning" onclick="trackOrder('<s:property value="orderId"/>')"> TRACK ORDER </button></td>
		    </s:else> 
			</tr>   
			</s:iterator>
</table>

</div>
</s:else>
<div class="p-3 mb-2 bg-light text-danger text-center">YourOrders</div>
<s:if test="%{myOrders.size()==0}">
	         No Orders
</s:if>
 <s:else>
 <c:set var="count" value="0" scope="page" />
<div class="container border border-light">
 <table id="mytable" class="table table-hover">
           <tr>
                <th>HOTEL NAME</th>
                <th>TOTAL</th>
                <th>DATE</th>
                <th>RATING</th>
               
            </tr>
            <s:iterator value="myOrders" status="stat">  
			<tr>
			<td><s:property value="hotelname"/></td>
			<td><s:property value="total"/></td>  
			<td><s:property value="date"/></td> 
			<s:if test="%{status==3}">
	         <td class="rating1"><input name="rate" id="${count}" type="text" value="" /></td>
	         <td class="ratebtn"><button  type="button" class="btn btn-outline-success ratebtn1" onclick="rateOrder('<s:property value="orderId"/>','<s:property value="%{#stat.index}" />')"> RATE </button></td>
		    </s:if> 
            <s:else>
			   <td class="rating1" ><span class="badge badge-success "><s:property  value="rating"/></span></td>
			   <td class="ratebtn"></td>
		    </s:else> 
		    <c:set var="count" value="${count + 1}" scope="page"/>
			</tr>   
			</s:iterator>
</table>
 </div>
 </s:else>
</body>
</html>