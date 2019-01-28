/**
 * 
 */

function test(o,h){
	  hotelsize=parseInt(h);
	  ordersize=parseInt(o);
	  if(hotelsize==0)
		  document.getElementById("hotelcontainer").innerHTML ="No Hotels";
	  if(ordersize==0)
		  document.getElementById("ordercontainer").innerHTML ="No Orders";
	
	  var st=document.getElementsByClassName("status");
	  var bt=document.getElementsByClassName("pickupbtn");
	  for(var i=0;i<hotelsize;i++)
		  {
		  var status=st[i].innerHTML;
		  st[i].innerHTML="";
		  if(status==0)
			  {
			   bt[i].disabled = true;
			   bt[i].innerHTML="CLOSED";
			  }
		  
		  }
	  
	 
		
		 var ti=document.getElementsByClassName("timer");
		 var bt=document.getElementsByClassName("deliverbtn");
		 
		 for(var i=0;i<ordersize;i++)
			 {
			  
			   var timer=ti[i].innerHTML;
			   ti[i].innerHTML="";
			  
			  
				     if(timer!=0)
				    	 {
				    	 bt[i].innerHTML=" <span class=\"badge badge-warning \">"+timer+"</span>";
				    	 }
				     
				  
			 }
	}

