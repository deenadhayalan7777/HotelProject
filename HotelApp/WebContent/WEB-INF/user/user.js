/**
 * 
 */

function test(s){
	 
	  size=parseInt(s,h);
	  if(size==0)
		  document.getElementById("hotelcontainer").innerHTML ="No Hotels";
	  
	
	  var st=document.getElementsByClassName("status");
	  var bt=document.getElementsByClassName("viewbtn");
	  for(var i=0;i<size;i++)
		  {
		  var status=st[i].innerHTML;
		  st[i].innerHTML="";
		  if(status==0)
			  {
			   bt[i].disabled = true;
			   bt[i].innerHTML="CLOSED";
			  }
		  
		  }
	  
		for(var i=0;i<parseInt(h);i++)	
			{
			   var id=document.getElementById("id"+i).value;
			   var name=document.getElementById("id"+name).value;
			}
			
	}

