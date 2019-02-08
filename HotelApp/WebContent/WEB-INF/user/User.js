/**
 * 
 */

function home()
{
	
	ajax("homeaction",function(data){
		
		 
		document.getElementById("home").className="nav-item active";
    	document.getElementById("my").className="nav-item";
    	 document.getElementById("tabdiv").innerHTML = data;
    	
	});
	
}

function myorders()
{
	ajax("myorders ",function(data){
		document.getElementById("home").className="nav-item";
    	document.getElementById("my").className="nav-item active";
    	 document.getElementById("tabdiv").innerHTML = data;
	});
}
function loc(id,name)
{
	
	  ajax("location?id="+id,function(data){
		  document.getElementById("navbarDropdown").innerHTML = name;
  	});
	  
	
}
function selectHotel(sno)
{
	
	  ajax("selecthotelaction?sno="+sno,function(data){
		  document.getElementById("tabdiv").innerHTML = data;
  	});
	  
	
}
function rateOrder(orderId,i)
{
	
	var rating=document.getElementById(i).value;
	var rate=parseInt(rating);
	if(rate<1||rate>5||rating=="")
		{alert("Enter rating within 1 to 5");
		 document.getElementById(i).value="";
		 return false;
		}
	var ratebtn=document.getElementsByClassName("rating1");
	ratebtn[i].disabled=true;
	  ajax("rateorderaction?rating="+rating+"&orderId="+orderId,function(data){
		    var ri=document.getElementsByClassName("rating1");
	   	    var rab=document.getElementsByClassName("ratebtn");
	    	ri[i].innerHTML= " <span class=\"badge badge-success \">"+rating+"</span>";
	    	rab[i].innerHTML="";
	});
	

}
function trackOrder(orderId)
{
	window.open("map?orderId="+orderId, "_blank");
	
}
class ItemQuantity{
	
	constructor(itemId,name,price,quantity)
	{
		this.itemId=itemId;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.subtotal=price*quantity;
	}
	
}
var itemslist=[];
var total=0;
var citems=1;
function addItem(itemId,name,price,status,quan)
{
	var q = document.getElementsByClassName("quantity");
	var quantity=q[parseInt(status)-1].value;
	var item=new ItemQuantity(parseInt(itemId),name,parseInt(price),parseInt(quan));
	var isRepeated=false;
	total+=item.subtotal;
	for (var i = 0; i < itemslist.length; i ++ ){
        
		if(itemslist[i].itemId==item.itemId)
			{
			  itemslist[i].quantity+=item.quantity;
			  itemslist[i].subtotal+=item.subtotal;
			  q[parseInt(status)-1].innerHTML=itemslist[i].quantity;
			  isRepeated=true;
			  break;
			}
			
     }
	if(!isRepeated)
	{
		
	  itemslist.push(item);
	  q[parseInt(status)-1].innerHTML=item.quantity;
	 
	}
	
	printList();
	
}
function removeItem(itemId,name,price,status,quan)
{
	var q = document.getElementsByClassName("quantity");
	
	var item=new ItemQuantity(parseInt(itemId),name,parseInt(price),parseInt(quan));
	
	
	for (var i = 0; i < itemslist.length; i ++ ){
        
		if(itemslist[i].itemId==item.itemId)
			{
			  if(itemslist[i].quantity>1)
				{
				  itemslist[i].quantity-=item.quantity;
				  itemslist[i].subtotal-=item.subtotal;
				  total-=item.subtotal;
				  q[parseInt(status)-1].innerHTML=itemslist[i].quantity;
				}  
			  else if(itemslist[i].quantity==1)
				  {
				  itemslist.splice( i, 1 );
				  total-=item.subtotal;
				  q[parseInt(status)-1].innerHTML="ADD";
				  }
			  
			  break;
			}
			
     }
	
	printList();
	
}
function printList()
{
	var html = "<table border='0' cellpadding='20'>";
	html+="<th>";
	html+="<tr>Name&nbsp;</tr>";
	html+="<tr>Price&nbsp;</tr>";
	html+="<tr>Quantity&nbsp;</tr>";
	html+="<tr>Subtotal</tr>";
	
	for (var i = 0; i < itemslist.length; i++) {
	    html+="<tr>";
	    html+="<td>"+itemslist[i].name+"</td>";
	    html+="<td>"+itemslist[i].price+"</td>";
	    html+="<td>"+itemslist[i].quantity+"</td>";
	    html+="<td>"+itemslist[i].subtotal+"</td>";
	    html+="</tr>";

	}

	html+="</table>";
	if(total>0)
	{html+="<p>Total= "+total+"</p>";
	}
	document.getElementById("box").innerHTML = html;
}
function makeOrder(hotelId)
{
	var location=document.getElementById("navbarDropdown").innerHTML;
	if(location.trim()===""||location.trim()==null)
	{
	 alert("Select User Location For delivery");
	 return false;
	}
    if(itemslist.length==0)
    	{
    	 alert("Add items to make order");
    	 return false;
    	}
	var itemString=JSON.stringify(itemslist);
	document.getElementById("makeorderbtn").disabled=true;
	postAjax('orderaction', {itemslist:itemString,total:total,hotelId:hotelId}, function(data){
		myorders(); });
	
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
function postAjax(url, data, success) {
    var params = typeof data == 'string' ? data : Object.keys(data).map(
            function(k){ return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
        ).join('&');

    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
    xhr.open('POST', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) { success(xhr.responseText); }
    };
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(params);
    return xhr;
}