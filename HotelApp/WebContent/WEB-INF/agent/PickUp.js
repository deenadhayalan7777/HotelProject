/**
 * 
 */


var orderslist=[];
var total=0;
function addOrder(n)
{
	
	var orderId=parseInt(n);
var isRepeated=false;	
 for (var i = 0; i < orderslist.length; i ++ ){
        
		if(orderslist[i]==orderId)
			{
			  isRepeated=true;
			  break;
			}
			
     }
  if(!isRepeated)
   {
	orderslist.push(orderId);
	total+=1;
   }
	printList();
}

function printList()
{
	var html = "orders picked "+total;
	
	document.getElementById("box").innerHTML = html;
}
function pickUpOrders()
{
	var orderString=JSON.stringify(orderslist);
	document.getElementById("orderslist").value=orderString;
	document.forms[0].submit();
	
}