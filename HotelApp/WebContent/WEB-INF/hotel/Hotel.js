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
function acceptOrder(i,orderId)
{
	var bt=document.getElementsByClassName("acceptbtn");
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	bt[i].innerHTML=" <span class=\"badge badge-success \">PREPARING</span>";
	    	
	    }
	  };
	  xhttp.open("GET", "orderacceptaction?orderId="+orderId, true);
	  xhttp.send();
	
	
}	

function changeStatus(i,id,stockt,vt)
{
	itemId=parseInt(id);
	stock=parseInt(stockt);
	val=parseInt(vt);
	
	if((val==1 && stock==0)||(val==0 && stock>0))
	{
		var on=document.getElementsByClassName("onbtn");
    	var off=document.getElementsByClassName("offbtn");
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	if(stock==0)
		    		{
		    		on[i].className="btn btn-success btn-sm onbtn";
			    	off[i].className="btn btn-default btn-sm offbtn";
			    	on[i].setAttribute( "onClick", "changeStatus("+i+","+itemId+",1,1)");
			    	off[i].setAttribute( "onClick", "changeStatus("+i+","+itemId+",1,0)");
		    		}
		    	else
		    		{
		    		on[i].className="btn btn-default btn-sm onbtn";
			    	off[i].className="btn btn-danger btn-sm offbtn";
			    	on[i].setAttribute( "onClick", "changeStatus("+i+","+itemId+",0,1)");
			    	off[i].setAttribute( "onClick", "changeStatus("+i+","+itemId+",0,0)");
		    		}
		    }
		  };
		  xhttp.open("GET", "changestockaction?itemId="+itemId, true);
		  xhttp.send();
	}

}

function addItem()
{
	var name=document.getElementById('name').value;
	var price=document.getElementById('price').value;
	var time=document.getElementById('time').value;
	var itembtn=document.getElementById('additembtn');
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
	itembtn.disabled=true;
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	document.getElementById('name').value="";
	    	document.getElementById('price').value="";
	    	document.getElementById('time').value="";
	    	itembtn.disabled=false;
	    }
	  };
	  xhttp.open("GET", "addmenuaction?itemslist="+itemString, true);
	  xhttp.send();
	
}

function status()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var status=document.getElementById("status").innerHTML;
	    	if(status=='CLOSE')
	    	 document.getElementById("status").innerHTML = "OPEN";
	    	else
	    	 document.getElementById("status").innerHTML="CLOSE";
	    }
	  };
	  xhttp.open("GET", "status", true);
	  xhttp.send();
	  
	
}
function home()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	document.getElementById("home").className="nav-item active";
	    	document.getElementById("menutab").className="nav-item ";
	    	document.getElementById("my").className="nav-item";
	    	document.getElementById("distab").className="nav-item";
	    	 document.getElementById("tabdiv").innerHTML = this.responseText;
	    	
	    }
	  };
	  xhttp.open("GET", "homeaction", true);
	  xhttp.send();
}
function myorders()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	document.getElementById("home").className="nav-item";
	    	document.getElementById("menutab").className="nav-item ";
	    	document.getElementById("my").className="nav-item active";
	    	document.getElementById("distab").className="nav-item";
	    	 document.getElementById("tabdiv").innerHTML = this.responseText;
	    	
	    }
	  };
	  xhttp.open("GET", "myorders", true);
	  xhttp.send();
}
function menu()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	document.getElementById("home").className="nav-item";
	    	document.getElementById("menutab").className="nav-item active";
	    	document.getElementById("my").className="nav-item";
	    	document.getElementById("distab").className="nav-item";
	    	 document.getElementById("tabdiv").innerHTML = this.responseText;
	    	
	    }
	  };
	  xhttp.open("GET", "menu", true);
	  xhttp.send();
}
function discount()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	document.getElementById("home").className="nav-item";
	    	document.getElementById("menutab").className="nav-item";
	    	document.getElementById("my").className="nav-item";
	    	document.getElementById("distab").className="nav-item active";
	    	 document.getElementById("tabdiv").innerHTML = this.responseText;
	    	
	    }
	  };
	  xhttp.open("GET", "discount", true);
	  xhttp.send();
}