<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
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

	<link rel="stylesheet"
	href="css/style.css"> 
	<!-- Self Made CSS file library import  -->
	
</head>
 <body
style="background-image: url(Images/chinaTemple.jpg); background-size:cover; background-attachment:fixed; height:100%; width:100%">	

<header class = "header">
	<b style = " position: relative;  left: 50px; color:white"><br/>Hello! ${userData.name}</b> 
	<a href="showAllContactInfo"> 
			<button type="button" class="btn btn-warning" style="position: absolute; top:5px; right: 90px;">Contact Us</button>
		</a>
		<!-- here I got the position of my text to be in the left side of the screen, so chose position: "relative" and for the buttons "Contact us and Logout" in the right side of the screen, so chose the position: "absolute"  -->
	<a href="logout"> <!-- Simple Button --> <!-- <button>Show Employees</button> -->
			<button type="button" class="btn btn-danger" style="position: absolute; top:5px; right: 10px;">LogOut</button>
		</a> <!-- Add a welcome message we the name in it --></header>
<br/>
<br/>
	
	
	

	<div class="container mb-3 mt-3">
	<font class="myTextStyle" face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font><br/><br/>
		 <img src="Images/beatifulScene.jfif"
			style="height: 180px">
				<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->
 
		
		<a href="showProfile?email=${userData.email}">
					<button type="button" class="btn btn-primary">Profile</button>
				</a>
				<a href="showAllEmployees"> <!-- Simple Button --> <!-- <button>Show Employees</button> -->
			<button type="button" class="btn btn-info">Employees</button>
		</a>
		<a href="register">
					<button type="button" class="btn btn-success">Register/Sign Up</button>
				</a>
					<a href="showAllEmployeesBlockTime"> <!-- Simple Button --> <!-- <button>Show Employees</button> -->
			<button type="button" class="btn btn-primary">Block Time</button>
		</a>
		
		
		
		 
		<!-- You can make a file like "process.jsp" as we go from 
		"register.jsp" to "process.jsp", this process file process 
		the request and sends back to the "register.jsp" page
		similarly, for logOutProcess, after the LogOut button is clicked,
		it goes to "LogOutProcess.jsp" and the processes it 
		and sends back to the "index.jsp" page. -->
		
		
		
		<hr />

			
		</div>


	<br/>
    <br/>
	<footer class = "footer">@Copyright Banepali 2020</footer>
</body>
</html>
