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

function addItem()
{
	
	
	var name=document.getElementById('name').value;
	var price=document.getElementById('price').value;
	var time=document.getElementById('time').value;
	if(name==="")
		{
		alert("name cant be blank");
		 return false;
		}
	if(isNaN(parseFloat(price)))
		{
		alert("price should be a number");
		 return false;
		}
	if(isNaN(parseFloat(time)))
	{
		alert("Preparation time should be in minutes(number)");
		 return false;
	}
	for(var i=0;i<namelist.length;i++)
		{
		
		if(name.trim() === namelist[i].trim())
		{
			alert("Item elready exists");
		 return false;
		}
	
		}
	
	var item=new Item(name,parseInt(price),parseInt(time),1);
	
	var itemString=JSON.stringify(item);
	document.getElementById("itemslist").value=itemString;
	document.forms[0].submit();
	
}
var namelist=[];
function test(s)
{
	var table = document.getElementById("mytable");
	var row=table.getElementsByTagName("tr");
	var size=parseInt(s);
	var n=document.getElementsByClassName("name");
	for (var i = 0; i < size; i ++ )
	{   
		var cell=row[i+1].getElementsByTagName("td");
		
		var stock=parseInt(cell[4].innerHTML);
	    var name=n[i].innerHTML;
	    namelist.push(name);
	    if(stock==0)
	    	{
	    	var on=document.getElementsByClassName("on");
	    	var off=document.getElementsByClassName("off");
	    	on[i].className="btn btn-default btn-sm on";
	    	off[i].className="btn btn-danger btn-sm off";
	    	}
	    cell[4].innerHTML="";
	}
	
	
}
function changeStatus(id,stockt,vt)
{
	itemId=parseInt(id);
	stock=parseInt(stockt);
	val=parseInt(vt);
	
	if((val==1 && stock==0)||(val==0 && stock>0))
	{
		document.getElementById("itemId").value=itemId;
		document.getElementById("stock").value=val;
		document.forms[1].submit();
	}

}