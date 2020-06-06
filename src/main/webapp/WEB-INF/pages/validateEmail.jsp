<!DOCTYPE html>
<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
<html>
<head>
<title>Email Validation</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<!-- For Awesome Fonts Library -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<!-- Self Made CSS file library import  -->

	<link rel="stylesheet"
	href="css/style.css"> 
	<!-- Self Made CSS file library import  -->
	


</head>
 <body
style="background-image: url(Images/chinaTemple.jpg); background-size:cover; background-attachment:fixed; height:100%; width:100%">	

	<header class = "header"></header>
<br/>
<br/>
	<div class="container mb-3 mt-3">
	<font class="myTextStyle" face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font><br/><br/>
		<img src="Images/beatifulScene.jfif" style="height: 180px">
		
		<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->

		<span style="font-size: 18px; color: red;">${message}</span>
		<hr />

		<div class="form-group" style="width: 50%">

			<form action="getNewPasswords" method="post">

			<!-- when you do not write this "method", then automatically, it calls the doGet() method and this get method will show all the data(password also) in the browser title. -->
			<!--methods are "post(secured), put, delete, patch, get(default and not secure)"  -->
			<!-- whenever the submit button is clicked, then this page is called -->

			<label for="email" style="color:white"> Email Address* </label> <input type="email"
				class="form-control" name="temail" required placeholder="Enter your Email">
				<!-- here putting "required makes the input field essential and input cannot just hit the "Search" button. 
				clicking "Search" button, without entering data, wont let the user go forward, asks for data to the user.  -->
			<br />
			
				<button class="btn btn-info">
					<!--  FA icons -->
					<i class="fa fa-search-alt fa-sm"></i>Search

				</button>
			</form>
			</div>
		</div>
		<br/>
		<br/>
		<footer class = "footer">@Copyright Banepali 2020</footer>
</body>
</html>