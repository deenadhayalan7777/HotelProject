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
function pickUpOrders(hotelId,size)
{
	var number=document.getElementById("number").value;
	var rate=parseInt(number);
	if(rate>parseInt(size))
		{alert("Requested number of orders not available in hotel");
		 document.getElementById(status).value="";
		 return false;
		}
	
	document.getElementById("hotelId").value=parseInt(hotelId);
	document.forms[0].submit();
	
}

function test(s){
	  
	if(parseInt(s)==0)
	document.getElementById("mydiv").innerHTML = "No orders";
	 
	
	 
	}