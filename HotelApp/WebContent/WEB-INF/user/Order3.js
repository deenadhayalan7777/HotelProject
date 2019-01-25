/**
 * 
 */

class ItemQuantity{
	
	constructor(itemId,name,price,quantity)
	{
		this.itemId=itemId;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.subtotal=price*quantity;
	}
	
}
var itemslist=[];
var total=0;
function addItem(itemId,name,price,status,quan)
{
	var q = document.getElementsByClassName("quantity");
	var quantity=q[parseInt(status)-1].value;
	var item=new ItemQuantity(parseInt(itemId),name,parseInt(price),parseInt(quan));
	var isRepeated=false;
	total+=item.subtotal;
	for (var i = 0; i < itemslist.length; i ++ ){
        
		if(itemslist[i].itemId==item.itemId)
			{
			  itemslist[i].quantity+=item.quantity;
			  itemslist[i].subtotal+=item.subtotal;
			  q[parseInt(status)-1].innerHTML=itemslist[i].quantity;
			  isRepeated=true;
			  break;
			}
			
     }
	if(!isRepeated)
	{
		
	  itemslist.push(item);
	  q[parseInt(status)-1].innerHTML=item.quantity;
	 
	}
	
	printList();
	
}
function removeItem(itemId,name,price,status,quan)
{
	var q = document.getElementsByClassName("quantity");
	
	var item=new ItemQuantity(parseInt(itemId),name,parseInt(price),parseInt(quan));
	
	
	for (var i = 0; i < itemslist.length; i ++ ){
        
		if(itemslist[i].itemId==item.itemId)
			{
			  if(itemslist[i].quantity>1)
				{
				  itemslist[i].quantity-=item.quantity;
				  itemslist[i].subtotal-=item.subtotal;
				  total-=item.subtotal;
				  q[parseInt(status)-1].innerHTML=itemslist[i].quantity;
				}  
			  else if(itemslist[i].quantity==1)
				  {
				  itemslist.splice( i, 1 );
				  total-=item.subtotal;
				  q[parseInt(status)-1].innerHTML="ADD";
				  }
			  
			  break;
			}
			
     }
	
	printList();
	
}
function printList()
{
	var html = "<table border='0' cellpadding='20'>";
	html+="<th>";
	html+="<tr>Name&nbsp;</tr>";
	html+="<tr>Price&nbsp;</tr>";
	html+="<tr>Quantity&nbsp;</tr>";
	html+="<tr>Subtotal</tr>";
	
	for (var i = 0; i < itemslist.length; i++) {
	    html+="<tr>";
	    html+="<td>"+itemslist[i].name+"</td>";
	    html+="<td>"+itemslist[i].price+"</td>";
	    html+="<td>"+itemslist[i].quantity+"</td>";
	    html+="<td>"+itemslist[i].subtotal+"</td>";
	    html+="</tr>";

	}

	html+="</table>";
	if(total>0)
	{html+="<p>Total= "+total+"</p>";
	}
	document.getElementById("box").innerHTML = html;
}
function makeOrder(hotelId)
{
	var itemString=JSON.stringify(itemslist);
	document.getElementById("itemslist").value=itemString;
	document.getElementById("total").value=total;
	document.getElementById("hotelId").value=parseInt(hotelId);
	document.forms[0].submit();
	
}