<!DOCTYPE html>
<html>
<head>
<title>Update Employee Data</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
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
	<font face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font><br/>
	<a href = "showAllData.jsp">
		<img src = "Images/beatifulScene.jfif" style = "height: 180px">
		</a>
			<!-- Simple Button -->
			<!-- <button>Show Employees</button> -->
		
		
		<hr/>
		
		<h1 style = "color: Blue">Employee Update Page</h1>
		
		<span style ="font-size: 18px; color: red;"><b>${message}</b></span>
		<hr/>
		
		<div class ="form-group" style = "width: 50%">
		
		<form action = "updateEmployeeData">   <!-- whenever the submit button is clicked, then this page is called -->
		
		<!-- In order to put the hidden values or data somewhere in the jsp file, do as following  -->
		
		<input type = "hidden" name = "userId" value = "${employeeEntity.userId}">
			
 			<label for = "userid" style="color:white"> UserId*: </label>
			<input type = "text" class = "form-control" name = "userid" placeholder = "Enter your UserID" value = "${employeeEntity.userId}" readonly>
			<!-- "readonly" for ReadOnly purpose -> cannot be changed here -->
			<br/>
			
			<label for = "password" style="color:white"> Password*: </label>
			<input type = "password" class = "form-control" name = "password" placeholder = "Enter your password" value = "${employeeEntity.password}">
			<br/>
			
			<label for = "name" style="color:white"> Name*: </label>
			<input type = "text" class = "form-control" name = "name" placeholder = "Enter your name" value = "${employeeEntity.name}">
			<br/>
			
			<label for = "email" style="color:white"> Email*: </label>
			<input type = "email" class = "form-control" name = "email" placeholder = "Enter your email" value = "${employeeEntity.email}">
			<br/>
			
			<label for = "dob" style="color:white"> Date of Birth*: </label>
			<input type = "date" class = "form-control" name = "dob" placeholder = "Enter your date of birth" value = "${employeeEntity.date}">
			<br/>
			
			<label for = "mobile" style="color:white"> Mobile: </label>
			<input type = "tel" class = "form-control" name = "mobile" placeholder = "Enter your mobile number" value = "${employeeEntity.mobile}">
			<br/>
			
			<label for = "salary" style="color:white"> Salary Range: </label>
			<select class = "form-control" name = "salary" >
						<option ${employeeEntity.salary ==0?'selected':'0'}>0</option>
						<option ${employeeEntity.salary ==500?'selected':'0'}>500</option>
						<option ${employeeEntity.salary ==1500?'selected':'0'}>1500</option>
						<option ${employeeEntity.salary ==2000?'selected':'0'}>2000</option>
						<option ${employeeEntity.salary ==2500?'selected':'0'}>2500</option>
						<option ${employeeEntity.salary ==3000?'selected':'0'}>3000</option>
						<option ${employeeEntity.salary ==3500?'selected':'0'}>3500</option> 
						<!-- for less than -> &lt; and greater than -> &gt;  -->
						
						<!-- In order to make the "value" in the  form "Required", follow this link, the third implementation
						https://www.w3docs.com/snippets/css/how-to-create-a-placeholder-for-an-html5-select-box-by-using-only-html-and-css.html
						-->
			</select>
			<br/>
			
			<label for = "ssn" style="color:white"> SSN*: </label>
			<input type = "number" class = "form-control" name = "ssn" placeholder = "Enter your ssn" value = "${employeeEntity.ssn}">
			<br/>
			
			
				<button type="submit" class="btn btn-success">Update</button>
				 <!-- We want to put all these inputed data into the DataBase when you press Register/Sign Up -> "process.jsp" -->
   				<button type="reset" class="btn btn-danger">Clear</button>
   					
   				
   		</form>

		</div>
		
	</div>
	<br/>
    <br/>
	<footer class = "footer">@Copyright Banepali 2020</footer>
</body>
</html>