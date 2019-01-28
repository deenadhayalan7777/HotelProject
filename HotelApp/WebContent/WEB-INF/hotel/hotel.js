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
	