/**
 * 
 */

class Item{
	
	constructor(name,price,time,stock)
	{
		this.itemId=1;
		this.name=name;
		this.price=price;
		this.time=time;
		this.stock=stock;
	}
	
}
var itemslist=[];
var total=0;
function addItem()
{
	var name=document.getElementById('name').value;
	var price=document.getElementById('price').value;
	var time=document.getElementById('time').value;
	var item=new Item(name,parseInt(price),parseInt(time),1);
	
	itemslist.push(item);
	document.getElementById('name').value="";
	document.getElementById('price').value="";
	document.getElementById('time').value="";
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

function test(s)
{
	var table = document.getElementById("mytable");
	var row=table.getElementsByTagName("tr");
	var size=parseInt(s);
	
	for (var i = 0; i < size; i ++ )
	{   
		var cell=row[i+1].getElementsByTagName("td");
		
		var stock=parseInt(cell[3].innerHTML);
	    
	    if(stock==0)
	    	{
	    	var on=document.getElementsByClassName("on");
	    	var off=document.getElementsByClassName("off");
	    	on[i].className="btn btn-default btn-sm on";
	    	off[i].className="btn btn-danger btn-sm off";
	    	}
	}
	
	
}
function changeStatus(id,stockt,vt)
{
	itemId=parseInt(id);
	stock=parseInt(stockt);
	val=parseInt(vt);
	
	if((val==1 && stock==0)||(val==0 && stock>1))
	{
		document.getElementById("itemId").value=itemId;
		document.getElementById("stock").value=val;
		document.forms[1].submit();
	}

}