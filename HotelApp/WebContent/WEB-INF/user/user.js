/**
 * 
 */

function test(s){
	 
	  size=parseInt(s);
	  if(size==0)
		  document.getElementById("hotelcontainer").innerHTML ="No Hotels";
	  
	
	  var st=document.getElementsByClassName("status");
	  var bt=document.getElementsByClassName("viewbtn");
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
	  
				  
			
	}

