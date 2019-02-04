/**
 * 
 */

function test(c,s)
{ 
	
	
	 var st=document.getElementsByClassName("status");
	 var ti=document.getElementsByClassName("timer");
	 var track=document.getElementsByClassName("track");
	 for(var i=0;i<parseInt(c);i++)
		 {
		   var status=st[i].innerHTML;
		   var timer=ti[i].innerHTML;
		   ti[i].innerHTML="";
		  
		  
		   if(status==0){
			   st[i].innerHTML="WAITING";
			   track[i].innerHTML="";
		         }
		   else if(status==1){
			   if(timer==0)
		    	 {
				   st[i].innerHTML="FOOD PREPARED, WAITING FOR AGENT";
				   track[i].innerHTML="";
		    	 }
			   else
				   {
				   st[i].innerHTML="PREPARING FOOD";
				   track[i].innerHTML="";
				   }
			  
			   
		         }
		   else {
			        st[i].innerHTML="ASSIGNED";
			       
		         }
		   
		   }
		   
		 
	
	 var st1=document.getElementsByClassName("status1");
	 var ri=document.getElementsByClassName("rating1");
	 var rab=document.getElementsByClassName("ratebtn");
	var size=parseInt(s);
	
	for (var i = 0; i < size; i ++ )
	{   
		var status=st1[i].innerHTML;
		   var rating=ri[i].innerHTML;;
		   st1[i].innerHTML="";
	    
	   if(status==3) {
		   
		 	ri[i].innerHTML="<input name=\"rate\" id=\""+ i+"\" type=\"text\" value=\"\" />";
	    }
	   else{
	    	ri[i].innerHTML= " <span class=\"badge badge-success \">"+rating+"</span>";
	    	rab[i].innerHTML="";
	         
	    }
	   
	}
}

function rateOrder(orderId,status)
{
	
	var rating=document.getElementById(status).value;
	var rate=parseInt(rating);
	if(rate<1||rate>5)
		{alert("Enter rating within 1 to 5");
		 document.getElementById(status).value="";
		 return false;
		}
	document.getElementById("rating").value=rating;
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
}

function trackOrder(orderId,status)
{
	
	document.getElementById("orderId1").value=parseInt(orderId);
	document.forms[1].submit();
	
}