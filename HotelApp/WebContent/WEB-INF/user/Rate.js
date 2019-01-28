/**
 * 
 */

function test(c,s)
{ 
	
	
	
	
	 
	 var st=document.getElementsByClassName("status");
	 var ti=document.getElementsByClassName("timer");
	
	 for(var i=0;i<parseInt(c);i++)
		 {
		   var status=st[i].innerHTML;
		   var timer=ti[i].innerHTML;
		   ti[i].innerHTML="";
		  
		   switch(status)
		   {
		   case 0:{
			   st[i].innerHTML="WAITING";
			   
		         }
		   case 1:{
			   if(timer==0)
		    	 {
				   st[i].innerHTML="FOOD PREPARED, WAITING FOR AGENT";
		    	 }
			   else
				   {
				   st[i].innerHTML="PREPARING FOOD";
				   }
		         }
		   case 2:{
			        st[i].innerHTML="ASSIGNED";
		         }
		   
		   }
		   
		 }
	
	var table = document.getElementById("mytable");
	var row=table.getElementsByTagName("tr");
	var size=parseInt(s);
	
	for (var i = 0; i < size; i ++ )
	{   
		var cell=row[i+1].getElementsByTagName("td");
		
		var status=parseInt(cell[3].innerHTML);
	    var rating=parseInt(cell[4].innerHTML);
	    cell[4].innerHTML="";
	    
	    switch(status)
	    {
	    case 0:{cell[3].innerHTML="WAITING";cell[5].innerHTML="";break;}	
	    case 1:{cell[3].innerHTML="ACCEPTED";cell[5].innerHTML="";break;}
	    case 2:{cell[3].innerHTML="ASSIGNED";cell[5].innerHTML="";break;}
	    case 3: {
	    	cell[3].innerHTML="DELIVERED";
	    	cell[4].innerHTML="<input name=\"rate\" id=\""+ i+"\" type=\"text\" value=\"\" />";
	    	     
	    break;        
	    }
	    case 4:{cell[3].innerHTML="DELIVERED";
	           cell[4].innerHTML= " <span class=\"badge badge-success \">"+rating+"</span>";
	           cell[5].innerHTML="";
	    break;       
	    }
	    }
	    
	    	
	    
	   
	}
}

function rateOrder(orderId,status)
{
	var q = document.getElementsByClassName("rate");
	var rating=document.getElementById(status).value;
	document.getElementById("rating").value=rating;
	document.getElementById("orderId").value=parseInt(orderId);
	document.forms[0].submit();
	
}