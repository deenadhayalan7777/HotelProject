/**
 * 
 */




function test(status,s){
	 var x = parseInt(status);
	 if(x==1)
	 document.getElementById("status").innerHTML ="CLOSE";
	 else
		document.getElementById("status").innerHTML="OPEN"; 
	 
	 var size=parseInt(s);
	 var st=document.getElementsByClassName("status");
	 var ti=document.getElementsByClassName("timer");
	 var bt=document.getElementsByClassName("acceptbtn");
	 if(size==0)
		  document.getElementById("ordercontainer").innerHTML ="No Orders";
	 for(var i=0;i<size;i++)
		 {
		   var status=st[i].innerHTML;
		   var timer=ti[i].innerHTML;
		   ti[i].innerHTML="";
		   st[i].innerHTML="";
		   if(status==1)
			   {
			     if(timer==0)
			    	 {
			    	 bt[i].innerHTML=" <span class=\"badge badge-success \">PREPARED</span>";
			    	 }
			     else
			    	 {
			    	 bt[i].innerHTML=" <span class=\"badge badge-danger \">"+timer+"</span>";
			    	 }
			   }
		 }
	 
	 
	}
function acceptOrder(orderId)
{
	
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
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