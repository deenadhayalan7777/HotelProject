/**
 * 
 */



function test(s)
{
	var table = document.getElementById("mytable");
	var row=table.getElementsByTagName("tr");
	var size=parseInt(s);
	
	for (var i = 0; i < size; i ++ )
	{   
		var cell=row[i].getElementsByTagName("td");
		
		var stock=parseInt(cell[3].innerHTML);
	    
	    if(stock==0)
	    	{
	    	cell[2].innerHTML="currently unavailable";
	    	}
	    cell[3].innerHTML="";
	}
	
	
}

function acceptOrder(orderId)
{
	
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
}