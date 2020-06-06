<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Show All Data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- For Awesome Fonts Library -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- For DataTables Library from here -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script
	src="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
	
</script>

<script src="https://kryogenix.org/code/browser/sorttable/sorttable.js">
	
</script>

<script>
	src = "https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" >
</script>


<!-- For DataTables upto here -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<!-- My Table name("myTable" for this case) included inside the <table> in ID section -->
<!-- This will not work if you have done the JAVA coding inside the jsp file. You will have to write your Java code in a seperate Servlet file for this   -->
<script>
	$('#myTable').DataTable();
</script>

<!-- Self Made CSS file library import  -->

	<link rel="stylesheet"
	href="css/style.css"> 
	<!-- Self Made CSS file library import  -->
	
</head>
 <body
style="background-image: url(Images/chinaTemple.jpg); background-size:cover; background-attachment:fixed; height:100%; width:100%">	

<header class = "header"><b style = "margin-left: 50px;">Hello! ${sessionScope.userData.name}</b></header>
<br/>
<br/>
	<div class="container mb-3 mt-3">
	<font class="myTextStyle" face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font><br/>
		<!--  margin bottom and margin top == 3-->
		<a href="showAllEmployees"> <img src="Images/beatifulScene.jfif"
			style="height: 180px">
		</a>
		<a href="register.jsp">
					<button type="button" class="btn btn-success">Register/Sign Up</button>
				</a>
		<a href="logout"> <!-- Simple Button --> <!-- <button>Show Employees</button> -->
			<button type="button" class="btn btn-warning">LogOut</button>
		</a>
		
		<br/>
		<br/>
		<span style = "font-size:18px; color: red;"  >${message} </span>
		<hr />
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->

		<!-- Read This first -->

		<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->

		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
		<!-- **************************************************************** -->
<!-- <th class="draggable right column_heading pointer marker" data-column="EID" style="cursor: move;"><span><a href="sql.php?db=keubiko_db&amp;table=employee_tbl&amp;sql_query=SELECT+%2A+FROM+%60employee_tbl%60++%0AORDER+BY+%60employee_tbl%60.%60EID%60++DESC&amp;sql_signature=8a6007a1a6227a12ef258f673e77a14d5859a7c1572eae5e676cb5d0d3f64184&amp;session_max_rows=25&amp;is_browse_distinct=0" class="sortlink">EID <img src="themes/dot.gif" title="" alt="Ascending" class="icon ic_s_asc soimg" style=""> <img src="themes/dot.gif" title="" alt="Descending" class="icon ic_s_desc soimg hide" style="display: none;"> <small>1</small><input type="hidden" value="sql.php?db=keubiko_db&amp;table=employee_tbl&amp;sql_query=SELECT+%2A+FROM+%60employee_tbl%60++%0AORDER+BY+%60employee_tbl%60.%60EID%60++DESC&amp;sql_signature=8a6007a1a6227a12ef258f673e77a14d5859a7c1572eae5e676cb5d0d3f64184&amp;session_max_rows=25&amp;is_browse_distinct=0"></a></span></th>
 --><!-- For movable Tables  -->
 
		<table id="myTable"
			class="table table-striped table-bordered sortable myFormStyle"  style="color:white" 
			>

			<thead>
				<tr>
				
				<!-- <th class="draggable right column_heading pointer marker" data-column="EID" style="cursor: move;">
				EID</th> -->
				
					<th>Eid</th>
					<th>UserId</th>
					<th>Name</th>
					<th>Email</th>
					<th>DOB(YYYY-MM-DD)</th>
					<th>Mobile Number</th>
					<th>Delete/Edit</th>
					<th>Active</th>
				</tr>
			</thead>
			
			<tbody> 
			
			<c:forEach items = "${employeeList}" var = "entity" >
				<tr>
					<td>${entity.eID}</td>
					<td>${entity.userId}</td>
					<td>${entity.name}</td>
					<td>${entity.email}</td>
					<td>${entity.date}</td>
					<td>${entity.mobile}</td>
					<td>
					<c:if test="${entity.email !=sessionScope.userData.email}">
					<a href="deletePerson?email=${entity.email}	">
							<!-- We are making a Servlet class named "deletePersonServlet" and "?" -> What you want to send as 
						to that Servlet Class "email=" and value of the email, which is being sent -->

							<!--  Whenever you send hyperlink, the method doGet() is called. -->
						<button class = "myBtn deleteBtn">
							<!--  FA icons -->
							<i class="far fa-trash-alt fa-sm"></i>
						</button>
						
					</a>
					</c:if>
					<!--  Whenever you send hyperlink, the method doGet() is called. -->
					<a href = "getEmployeeDataForEdit?userId=${entity.userId}" >
					<button class="myBtn editBtn"><i class="fa fa-edit fa-sm"></i></button>
					</a>
					
					
					</td>
					
					
					
					<td>
					
					<c:if test="${entity.active == 'YES'}">
					<a href = "changeEmployeeActiveSession?userId=${entity.userId}" ><!--  Whenever you send hyperlink, the method doGet() is called. -->
					<button class="myBtn unlockBtn"><i class="fa fa-unlock fa-sm"></i>
						</button>
					
					
					</a>
					</c:if>
					
					
					<c:if test="${entity.active == 'NO'}"><!--  Whenever you send hyperlink, the method doGet() is called. -->
					<a href = "changeEmployeeActiveSession?userId=${entity.userId}" ><!--  Whenever you send hyperlink, the method doGet() is called. -->
					
					<button class="myBtn lockBtn"><i class="fa fa-lock fa-sm"></i> </button> 
					</a>					
					</c:if>
					</td>
					
					
					
					
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
    <br/>
    <br/>
	<footer class = "footer">@Copyright Banepali 2020</footer>


</body>
</html>
