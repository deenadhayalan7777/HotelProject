/**
 * 
 */

class Item{
	
	constructor(name,price)
	{
		this.itemId=1;
		this.name=name;
		this.price=price;
		
		
	}
	
}
var itemslist=[];
var total=0;
function addItem()
{
	var name=document.getElementById('name').value;
	var price=document.getElementById('price').value;
	var item=new Item(name,parseInt(price));
	
	itemslist.push(item);
	document.getElementById('name').value="";
	document.getElementById('price').value="";
	printList();
}

function printList()
{
	var html = "<table border='0'>";
	html+="<th>";
	html+="<tr>Name</tr>";
	html+="<tr>Price</tr>";
	html+="</th>";
	
	for (var i = 0; i < itemslist.length; i++) {
	    html+="<tr>";
	    html+="<td>"+itemslist[i].name+"</td>";
	    html+="<td>"+itemslist[i].price+"</td>";
	    html+="</tr>";

	}
	html+="</table>";
	
	document.getElementById("box").innerHTML = html;
}
function addItems()
{
	var itemString=JSON.stringify(itemslist);
	document.getElementById("itemslist").value=itemString;
	document.forms[0].submit();
	
}