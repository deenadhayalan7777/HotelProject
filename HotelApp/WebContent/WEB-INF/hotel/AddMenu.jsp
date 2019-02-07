<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body >
<div class="p-3 mb-2 bg-light text-danger text-center">Hotel Menu</div>
 <s:if test="%{menu.size()==0}">
	      No Menu Items
       </s:if>
 <s:else>
 <div class="container" id="ordercontainer">
 <table id="mytable" border="0" cellpadding="20">
   <tr>
                <th>NAME</th>
                <th>PRICE</th>
                <th>PREPARATION TIME</th>
                <th>STOCK</th>
            </tr>
   <s:iterator  value="menu" status="stat">  
           
			<tr>
			<td class="name"><s:property value="name"/></td>  
			<td><s:property value="price"/></td>  
			<td><s:property value="time"/></td>
			
			<td>
			 <s:if test="%{stock==0}">
	         <div class="btn-group" role="group" aria-label="Basic example">
             <button type="button" class="btn btn-default btn-sm on" onclick="changeStatus('<s:property value="%{#stat.index}"/>','<s:property value="itemId" />','<s:property value="stock" />','1')" >ON</button>
             <button type="button" class="btn btn-danger btn-sm off" onclick="changeStatus('<s:property value="%{#stat.index}"/>','<s:property value="itemId" />','<s:property value="stock" />','0')" >OFF</button>
            </div>
            </s:if>
             <s:else>
			<div class="btn-group" role="group" aria-label="Basic example">
            <button type="button" class="btn btn-success btn-sm on" onclick="changeStatus('<s:property value="%{#stat.index}"/>','<s:property value="itemId" />','<s:property value="stock" />','1')" >ON</button>
            <button type="button" class="btn btn-default btn-sm off" onclick="changeStatus('<s:property value="%{#stat.index}"/>','<s:property value="itemId" />','<s:property value="stock" />','0')" >OFF</button>
            </div>
            </s:else>
            </td>
            <td><s:property value="stock"/></td>
			</tr>  
  </s:iterator> 
  </table>
  </div>
 </s:else> 
 
  <input name="name" id="name" type="text" placeholder ="Name"/>
  <input name="price" id="price" type="text" placeholder ="Price"/>
  <input name="time" id="time" type="text" placeholder ="Preparation time" />
  <button class="btn btn-outline-success" id="additembtn" onclick="addItem()" >ADD ITEM</button>
</body>
</html>