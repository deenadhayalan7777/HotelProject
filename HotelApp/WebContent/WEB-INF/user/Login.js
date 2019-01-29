/**
 * 
 */

function validate(){
	 
	 var username = document.forms["myForm"]["username"].value;
	 var password = document.forms["myForm"]["password"].value;
	 var x = document.forms["myForm"]["x"].value;
	 var y = document.forms["myForm"]["y"].value;
	 
	 var correct=true;
	  if (username == "") {
	    alert("Name must be filled out");
	    correct= false;
	  }
	
	  if (password == "") {
		    alert("Enter password");
		    correct= false;
		  }
	  if (x == "") {
		    alert("Enter x coordinate");
		    correct= false;
		  }
	  if (y == "") {
		    alert("Enter y coordinate");
		    correct= false;
		  }
	  if(correct)
		  document.forms[0].submit();
	}

