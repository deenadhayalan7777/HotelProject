/**
 * 
 */




function acceptOrder(orderId)
{
	
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
}