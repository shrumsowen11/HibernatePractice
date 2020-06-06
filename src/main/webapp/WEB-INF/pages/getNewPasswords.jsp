<!DOCTYPE html>
<html>
<head>
<title>Creating new Password Page</title>
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
	
<style>
.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}
</style>

</head>
 <body
style="background-image: url(Images/chinaTemple.jpg); background-size:cover; background-attachment:fixed; height:100%; width:100%">	

	<header class = "header"></header>
		<br/>
		<br/>
	<div class="container mb-3 mt-3">
	<font face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font>
		<img src="Images/beatifulScene.jfif" style="height: 180px">

		<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->

		<span style="font-size: 18px; color: red;">${message}</span>
		<hr />

		<div class="form-group" style="width: 50%">

			<form action="updatePasswordEquality" method = "post">
				<%-- <%String email = (String) request.getParameter("temail");%> --%>
				<label for="password" style="color:white"> Enter a new password*: </label> 
				<input type="password" class="form-control" name="password1" required
					placeholder="Enter your new password.."> <br /> 
					
					<label for="password" style="color:white"> Re-enter a new password*: </label> 
					<input type="password" class="form-control" name="password2" required
					placeholder="Enter your new password again.."> <br />
					
					
					<button type="submit" class="btn btn-success">Submit</button>
					<!-- this might be done in servlet -->
					
					
					
					
				
			</form>
		</div>
	</div>
	<br/>
    <br/>
	<footer class = "footer">@Copyright Banepali 2020</footer>
</body>
</html>