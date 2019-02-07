<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

<div class="p-3 mb-2 bg-light text-danger text-center">Hotel Menu</div>
<s:if test="%{menu.size()==0}">
	         No Items
</s:if>
 <s:else>
  
  <table id="mytable" border="0" cellpadding="20">
   <s:iterator  value="menu" status="status">  
			<tr>
			<td><s:property value="name"/></td>  
			<td><s:property value="price"/></td> 
			<td>
            <s:if test="%{stock==0}">
	        <span class="badge badge-secondary quantity">CURRENTLY UNAVAILABLE</span>
            </s:if>
            <s:else>
            <button type="button" class="btn btn-outline-success" onclick="removeItem('<s:property value="itemId"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="%{#status.count}" />','1')">-</button>   <span class="badge badge-success quantity">ADD</span>  <button type="button" class="btn btn-outline-success" onclick="addItem('<s:property value="itemId"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="%{#status.count}" />','1')">+</button>
	        </s:else>
            </td>
		    </tr>  
  </s:iterator> 
  </table>
</s:else>  
  <p id="box" > </p>

 <button type="button" class="btn btn-outline-success"  onclick="makeOrder('<s:property value="#session.hdetail.hotelId"/> ')" >MAKE ORDER</button>

</body>
</html>