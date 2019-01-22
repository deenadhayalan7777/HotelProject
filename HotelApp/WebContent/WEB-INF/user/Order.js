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
function addItem(itemId,name,price,status)
{
	var q = document.getElementsByClassName("quantity");
	var quantity=q[parseInt(status)-1].value;
	var item=new ItemQuantity(parseInt(itemId),name,parseInt(price),parseInt(quantity));
	var isRepeated=false;
	total+=item.subtotal;
	for (var i = 0; i < itemslist.length; i ++ ){
        
		if(itemslist[i].itemId==item.itemId)
			{
			  itemslist[i].quantity+=item.quantity;
			  itemslist[i].subtotal+=item.subtotal;
			  isRepeated=true;
			  break;
			}
			
     }
	if(!isRepeated)
	itemslist.push(item);
	q[parseInt(status)-1].value="";
	printList();
	
}

function printList()
{
	var html = "<table border='1|1'>";
	html+="<th>";
	html+="<tr>Name</tr>";
	html+="<tr>Price</tr>";
	html+="<tr>Quantity</tr>";
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
	html+="<p>Total= "+total+"</p>";
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