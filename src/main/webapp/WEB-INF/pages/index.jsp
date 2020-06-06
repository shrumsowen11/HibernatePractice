<!DOCTYPE html>
<html>
<head>
<title>Sample LogIn</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<!-- Self Made CSS file library import  -->

<link rel="stylesheet" href="css/style.css">
<!-- Self Made CSS file library import  -->

</head>
<body
style="background-image: url(Images/chinaTemple.jpg); background-size:cover; background-attachment:fixed; height:100%; width:100%">	


	<header class="header">
	 <b style="margin-left: 20px;">${applicationScope.email}</b>
     
      <b style="margin-left: 20px;">Mobile : ${applicationScope.mobile}</b>
	</header>
	<br />
	<br />
	
	<font class="myTextStyle" face="Showcard Gothic" size="5">WARLIONS
		</font>


		<hr style="opacity: 50" />
	<div class="container mb-3 mt-3">

		<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->




		<!-- span for making the "passed message" beautiful -->
		<!-- <font face = "Showcard Gothic" size = "5" style="color: #9afadaa6; text-shadow: 4px 2px 5px #e0b00a;">WARLIONS</font><br/> -->
		


	 <div class="row "> 
			<div class="col-md-2 col-sm-2 col-xs-12"></div>
			<div class="col-md-8 col-sm-8 col-xs-12 ">
						<img src="Images/beatifulScene.jfif" style="margin-left: auto; display:block; margin-right: auto; width = 50%;"><br />

				<div class="form-group" style=" width: 100%">

					<form action="login" class = "myFormStyle" method="post">
						<h4><span style="font-size: 18px; color: red ; /* #ec8484 - slight pinky red */" ><b>${message}</b></span></h4><br/>   <!-- Try to add the blinking effect  -->
						<!-- when you do not write this "method", then automatically, it calls the doGet() method and this get method will show all the data(password also) in the browser title. -->
						<!--methods are "post(secured), put, delete, patch, get(default and not secure)"  -->
						<!-- whenever the submit button is clicked, then this page is called -->
							
						<h3 style="color: #e5fb2f/* light yellow */">Sign In:</h3>
						<label for="email" style="color:white"> <b>Email Address* </b></label>
						 <input type="email" class="form-control" name="temail" required
							placeholder="Enter your Email"> <br /> 
							
							
						<label for="password" style="color:white"><b>Password* </b> </label> 
						<input type="password" class="form-control" name="password" required
							 placeholder="Enter your password"> <br />



						<button type="submit" class="btn btn-primary">Log In</button>
						
						<a href = "register" >
							<button type="button" class="btn btn-success">Register/Sign
								Up</button>
						</a>
						
					
						<button type="reset" class="btn btn-danger">Clear</button>
						<br /> <br /> <a href="validateEmail"> <font color="red">Forgot Password?</font></a>

					</form>
				</div>



			</div>



			<div class="col-md-2 col-sm-2 col-xs-12"></div>


		 </div>
	</div>

	<br />
	<br />
	<footer class="footer">@Copyright Banepali 2020</footer>
</body>
</html>