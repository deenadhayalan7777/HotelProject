/**
 * 
 */
var isPicked=false;

function loc(id,name)
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	 document.getElementById("navbarDropdown").innerHTML = name;
	    	
	    }
	  };
	  xhttp.open("GET", "location?id="+id, true);
	  xhttp.send();
	  
	
}
function deliver(sno)
{
	 var bt=document.getElementsByClassName("deliverbtn");
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	bt[sno].innerHTML=" <span class=\"badge badge-success \">DELIVERED</span>";
	    	
	    }
	  };
	  xhttp.open("GET", "deliveryaction?sno="+sno, true);
	  xhttp.send();
	  
	
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
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	window.location.reload();
	    }
	  };
	  xhttp.open("GET", "pickupaction?hotelId="+hotelId+"&number="+number, true);
	  xhttp.send();
	
	  
	
}

function pickup(sno)
{
	if(!isPicked)
	{ var pick=document.getElementsByClassName("pick");
	var bt=document.getElementsByClassName("pickupbtn");
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	pick[sno].innerHTML=this.responseText;
	    	bt[sno].innerHTML="CLOSE";
	    	bt[sno].className="btn btn-outline-danger pickupbtn";
	    	isPicked=true;
	    	bt[sno].setAttribute( "onClick", "closeChoice("+sno+")" );
	    
	    }
	  };
	  xhttp.open("GET", "selecthotelaction?sno="+sno, true);
	  xhttp.send();
	}
	else
		alert("Close the selected hotel");
	
}
function closeChoice(sno)
{
	console.log("In close") ;
	var bt=document.getElementsByClassName("pickupbtn");
	var pick=document.getElementsByClassName("pick");
	pick[sno].innerHTML="";
	isPicked=false;
	bt[sno].innerHTML="PICKUP";
	bt[sno].className="btn btn-outline-info pickupbtn";
	bt[sno].setAttribute( "onClick", "pickup("+sno+")" );
	
	console.log("After Close")
}
function myorders()
{
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	
	    	document.getElementById("my").className="nav-item active ";
	    	document.getElementById("home").className="nav-item ";
	    	 document.getElementById("tabdiv").innerHTML = this.responseText;
	    	
	    }
	  };
	  xhttp.open("GET", "myorders", true);
	  xhttp.send();
	  
	
}
