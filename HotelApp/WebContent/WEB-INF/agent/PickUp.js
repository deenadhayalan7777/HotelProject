/**
 * 
 */


var orderslist=[];
var total=0;
function addOrder(n)
{
	
	var orderId=parseInt(n);
var isRepeated=false;	
 for (var i = 0; i < orderslist.length; i ++ ){
        
		if(orderslist[i]==orderId)
			{
			  isRepeated=true;
			  break;
			}
			
     }
  if(!isRepeated)
   {
	orderslist.push(orderId);
	total+=1;
   }
	printList();
}

function printList()
{
	var html = "orders picked "+total;
	
	document.getElementById("box").innerHTML = html;
}
function pickUpOrders()
{
	var orderString=JSON.stringify(orderslist);
	document.getElementById("orderslist").value=orderString;
	document.forms[0].submit();
	
}

function test(s){
	  
	 var size=parseInt(s);
	 var st=document.getElementsByClassName("status");
	 var ti=document.getElementsByClassName("timer");
	 var bt=document.getElementsByClassName("pickupbtn");
	 var rh=document.getElementsByClassName("rowh");
	 for(var i=0;i<size;i++)
		 {
		   var status=st[i].innerHTML;
		   var timer=ti[i].innerHTML;
		   ti[i].innerHTML="";
		   st[i].innerHTML="";
		   
		   if(status==1)
			   {
			     if(timer!=0)
			    	 {
			    	 bt[i].innerHTML=" <span class=\"badge badge-danger \">"+timer+"</span>";
			    	 }
			     
			   }
		   else
			   {
			   bt[i].innerHTML=" <span class=\"badge badge-secondary \">WAITING</span>";
			   }
		  
		 }
	 
	
	 
	}