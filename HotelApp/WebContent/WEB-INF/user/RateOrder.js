/**
 * 
 */



function rateOrder(orderId,status)
{
	var q = document.getElementsByClassName("rate");
	var rating=q[parseInt(status)-1].value;
	document.getElementById("rating").value=rating;
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
}