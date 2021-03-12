 var a=10;
 var b="john";
 var c=10.2;
 var d=true;
 var e=["orange","banana","mango"];
 var f={
		name : "john",
		age : 10,
		grade : 2,
		learn : function(  ){
			console.log("attending class");
		}
	};

 test();
 // tightly coupled
 function disappearImage1(){
	 //document.getElementById("cart").style="display:none";
	 $("#cart").hide();
 }
 function appearImage(){
	 document.getElementById("cart").style="display:block";
 }
 
function jsVerifyLoginForm(){
	
	var customerEnteredUid=document.getElementById("uid").value;
	var customerEnteredpwd=document.getElementById("pwd").value;
	 
	
	if(customerEnteredUid == "" )
	{
		alert(" userid is mandatory");
		document.getElementById("uid").style="background:red";
		return false;
	}
	if(customerEnteredpwd == "" )
	{
		alert("  password is mandatory");
		document.getElementById("pwd").style="background:red";
		return false;
	} 
	
}
 

function add(a, b){
	 var sum=a+b;
	 return sum;
}

 function test(){
	 var subResult=sub(20,30);
	 console.log("sub is:"+subResult);
	 
	 
	 var result=add(10,20);
	 console.log("sum is:"+ result  );

	 console.log(a);
	 console.log(b);
	 console.log(c);
	 console.log(d);
	 console.log(e);
	 console.log(f.name);
	 f.learn();
	 
	    try{
			 var fullName="john doe";
			 var x=fullName.split(" ");
			 console.log(x);
		}catch(e){
			console.log("error caught");
		}finally{
			console.log("finally block");
		}
		
		
		var email="abc@g.com";
		if(   email.indexOf("@") == -1 )
			console.log("invalid email id");
		else
			console.log("valid email id");
		
		
		email=email.replace("a","c");
		console.log(email);
		
		console.log(email.toUpperCase());
		
		console.log(email.toLowerCase());
		//abc@g.com
		console.log(  email.substring (1,3));
		
		var arr=email.split("@");
		console.log(arr);
		
		var asd="  john  ";
		console.log(":"+ asd.trim() + ":");
		// if else
		var aa="john";
		var bb="john";
		if ( aa == bb || 1<2){
			console.log("same");
		}
		else{
			console.log("not same");
		}
		
		// for loop
		for(i=0; i < 3;i++)
			console.log("hello :"+i);
		
		
		// while loop
		var x=0;
		while(x <= 2){
			console.log("while loop");
			x++;	
		}
		
 }
 
 //	JQUERY CODE
 
 $(document).ready(function() {
		$("#submit").click(jqueryVerifyLoginForm);
		$("#fruitname").blur(testFruit);
		$("#header").mouseenter(disapperCrt);
		$("#header").mouseleave(apperCrt);
		
	});
 function disapperCrt(){
	 $("#cart").fadeOut(5000);
 }
 function apperCrt(){
	 $("#cart").fadeIn(5000);
 }
 function testFruit(){
	 // no input to val method - reads text box value
	 var fruit=$("#fruitname").val(   );
	 if(fruit == "newyork")
		 // val method with input - set text box value
		 $("#fruitcolor").val("US");
	 if(fruit == "tokyo")
		 $("#fruitcolor").val("Japan");
	 
 }
 function jqueryVerifyLoginForm(){
	 	var customerEnteredUid=$("#uid").val();
	 	var customerEnteredpwd=$("#pwd").val();
	 	if(customerEnteredUid == "" )
	 	{
	 		$("#submit").hide();
	 		$("#uid").addClass("redcolor");
	 		alert(" userid  is mandatory");
	 		return false;
	 	}
	 	if(customerEnteredpwd == "" )
	 	{
	 		$("#submit").fadeOut(5000);
	 		$("#pwd").css("background","red")
	 		alert(" password  is mandatory");
	 		return false;
	 	}
}
 
testJquery();
function testJquery(){
	var aw=$("li.test").siblings().text();
	console.log("::"+aw);
}

