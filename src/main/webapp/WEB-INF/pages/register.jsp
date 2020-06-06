<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
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
	style="background-image: url(Images/chinaTemple.jpg); background-size: cover; background-attachment: fixed; height: 100%; width: 100%">

	<header class="header"></header>
	<br />
	<br />
	<div class="container mb-3 mt-3">
		<font class="myTextStyle" face="Showcard Gothic" size="5"
			style="color: #00ffaca6;">WARLIONS</font><br /> <a
			href="showAllData.jsp"> <img src="Images/beatifulScene.jfif"
			style="height: 180px">
		</a>
		<!-- Simple Button -->
		<!-- <button>Show Employees</button> -->


		<hr />

		<h1 style="color: #e8d5b9">
			<b>Employee Registration Page</b>
		</h1>

		<span style="font-size: 18px; color: red;"><b>${message}</b></span>
		<hr />

		<div class="form-group" style="width: 50%">

			<form action="rregister"
				method="post" enctype="multipart/form-data">

				<label for="userid" style="color: white"> UserId* </label> <input
					type="text" class="form-control" name="userId" required
					placeholder="Enter your UserID"> <br /> <label
					for="password" style="color: white"> Password* </label> <input
					type="password" class="form-control" name="password" required
					placeholder="Enter strong password"> <br /> <label
					for="name" style="color: white"> Name* </label> <input type="text"
					class="form-control" name="name" required
					placeholder="Enter your name"> <br /> <label for="email"
					style="color: white"> Email* </label> <input type="email"
					class="form-control" name="email" required
					placeholder="Enter your email"> <br /> <label for="dob"
					style="color: white"> Date of Birth* </label> <input type="date"
					class="form-control" name="date" required
					placeholder="Enter your date of birth"> <br /> <label
					for="mobile" style="color: white"> Mobile </label> <input
					type="tel" class="form-control" name="mobile" required
					placeholder="Enter your mobile number"> <br /> <label
					for="salary" style="color: white"> Salary Range </label> <select
					class="form-control" name="salary" required>
					<option selected>0</option>
					<option>500</option>
					<option>1500</option>
					<option>2000</option>
					<option>2500</option>
					<option>3000</option>
					<option>3500</option>
					<!-- for less than -> &lt; and greater than -> &gt;  -->

					<!-- In order to make the form "Require" this value follow this link, the third implementation
						https://www.w3docs.com/snippets/css/how-to-create-a-placeholder-for-an-html5-select-box-by-using-only-html-and-css.html
						-->
				</select> <br /> <label for="ssn" style="color: white"> SSN* </label> <input
					type="number" class="form-control" name="ssn" required
					placeholder="Enter your ssn"> <br /> 
					
					
				<label for="photo" style="color: white"> Choose your Profile Photo </label>
				<input type = "file" class = "form-control"  name = "photo" style = "height : 45px ; align-items : flex-end">
				<!-- <img src="Images/coolguy.jpg" id="upfile1" style="cursor: pointer" />
				<input type="file" id="file1" name="file1" style="display: none" />-->
				<br />
<br/> 
				
				
				<a href="index">
					<button type="button" class="btn btn-primary">Log In</button>
				</a>
				<button type="submit" class="btn btn-success">Register/Sign
					Up</button>
				<!-- We want to put all these inputed data into the DataBase when you press Register/Sign Up -> "process.jsp" -->
				<button type="reset" class="btn btn-danger">Clear</button>


			</form>

		</div>

	</div>
	<br />
	<br />
	<footer class="footer">@Copyright Banepali 2020</footer>
</body>
</html>