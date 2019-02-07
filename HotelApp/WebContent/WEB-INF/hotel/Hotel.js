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
	ajax("orderacceptaction?orderId="+orderId,function(data){
	var bt=document.getElementsByClassName("acceptbtn");
	bt[i].innerHTML=" <span class=\"badge badge-success \">PREPARING</span>";
	});
	
	
	
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
		  xhttp.open("GET", "changestockaction?itemId="+itemId+"&stock="+val, true);
		  xhttp.send();
	}

}

function addItem()
{
	var name=document.getElementById('name').value;
	var price=document.getElementById('price').value;
	var time=document.getElementById('time').value;
	var itembtn=document.getElementById('additembtn');
	var namelist=document.getElementsByClassName("namelist");
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
		
			if(name.trim() === namelist[i].innerHTML)
			{
				alert("Item elready exists");
			 return false;
			}
	
		}
	
	var item=new Item(name,parseInt(price),parseInt(time),1);
	
	var itemString=JSON.stringify(item);
	itembtn.disabled=true;
	postAjax('addmenuaction', {itemslist:itemString}, function(data){
		document.getElementById("home").className="nav-item";
    	document.getElementById("menutab").className="nav-item active";
    	document.getElementById("my").className="nav-item";
    	document.getElementById("distab").className="nav-item";
    	 document.getElementById("tabdiv").innerHTML = data; });
	
	
}

function status()
{
	ajax("status ",function(data){
		var status=document.getElementById("status").innerHTML;
    	if(status=='CLOSE')
    	 document.getElementById("status").innerHTML = "OPEN";
    	else
    	 document.getElementById("status").innerHTML="CLOSE";
	});

}
function home()
{
	ajax("homeaction",function(data){
		
		document.getElementById("home").className="nav-item active";
    	document.getElementById("menutab").className="nav-item ";
    	document.getElementById("my").className="nav-item";
    	document.getElementById("distab").className="nav-item";
    	 document.getElementById("tabdiv").innerHTML = data;
    	
	});
	
}
function myorders()
{
	ajax("myorders ",function(data){
		document.getElementById("home").className="nav-item";
    	document.getElementById("menutab").className="nav-item ";
    	document.getElementById("my").className="nav-item active";
    	document.getElementById("distab").className="nav-item";
    	 document.getElementById("tabdiv").innerHTML = data;
	});
	
}
function menu()
{
	ajax("menu ",function(data){
		document.getElementById("home").className="nav-item";
    	document.getElementById("menutab").className="nav-item active";
    	document.getElementById("my").className="nav-item";
    	document.getElementById("distab").className="nav-item";
    	 document.getElementById("tabdiv").innerHTML = data;
	});
	
}
function discount()
{
	
	ajax("discount",function(data){
		    document.getElementById("home").className="nav-item";
	    	document.getElementById("menutab").className="nav-item";
	    	document.getElementById("my").className="nav-item";
	    	document.getElementById("distab").className="nav-item active";
	    	 document.getElementById("tabdiv").innerHTML = data;
	    	 });
	

}

function ajax(url,success)
{
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	success(this.responseText);
	    }
	    	
	  };
	  xhttp.open("GET", url, true);
	  xhttp.send();
}
function postAjax(url, data, success) {
    var params = typeof data == 'string' ? data : Object.keys(data).map(
            function(k){ return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
        ).join('&');

    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
    xhr.open('POST', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) { success(xhr.responseText); }
    };
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(params);
    return xhr;
}