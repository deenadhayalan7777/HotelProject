/**
 * 
 */
var isPicked=false;

function loc(id,name)
{
	ajax("location?id="+id,function(data){
		 document.getElementById("navbarDropdown").innerHTML = name;
	});
	
}
function deliver(sno)
{
	ajax("deliveryaction?sno="+sno,function(data){
		var bt=document.getElementsByClassName("deliverbtn");	
		bt[sno].innerHTML=" <span class=\"badge badge-success \">DELIVERED</span>";
    	
	});
	
	
}

function pickUpOrders(hotelId,size)
{
	var number=document.getElementById("number").value;
	var rate=parseInt(number);
	if(rate>parseInt(size))
		{alert("Requested number of orders not available in hotel");
		 document.getElementById(number).value="";
		 return false;
	 }
	ajax("pickupaction?hotelId="+hotelId+"&number="+number ,function(data){
	 	 home();
     });
	
}

function pickup(sno)
{
	if(!isPicked)
	{ var pick=document.getElementsByClassName("pick");
	var bt=document.getElementsByClassName("pickupbtn");
	 bt[sno].disabled=true;
	 ajax("selecthotelaction?sno="+sno,function(data){
		 var pick=document.getElementsByClassName("pick");
	    	var bt=document.getElementsByClassName("pickupbtn");
	    	bt[sno].disabled=false;
	    	pick[sno].innerHTML=this.responseText;
	    	bt[sno].innerHTML="CLOSE";
	    	bt[sno].className="btn btn-outline-danger pickupbtn";
	    	isPicked=true;
	    	bt[sno].setAttribute( "onClick", "closeChoice("+sno+")" );

	 });
	
	}
	else
		alert("Close the selected hotel");
	
}
function closeChoice(sno)
{
	
	var bt=document.getElementsByClassName("pickupbtn");
	var pick=document.getElementsByClassName("pick");
	pick[sno].innerHTML="";
	isPicked=false;
	bt[sno].innerHTML="PICKUP";
	bt[sno].className="btn btn-outline-info pickupbtn";
	bt[sno].setAttribute( "onClick", "pickup("+sno+")" );
	
}
function myorders()
{
	
	ajax("myorders" ,function(data){
		document.getElementById("my").className="nav-item active ";
    	document.getElementById("home").className="nav-item ";
    	 document.getElementById("tabdiv").innerHTML = data;
 	
	});
	
}

function home()
{
	ajax("homeaction" ,function(data){
		document.getElementById("my").className="nav-item";
    	document.getElementById("home").className="nav-item active";
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