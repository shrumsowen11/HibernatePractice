<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%-- <%@page import="java.util.ArrayList"%>
<%@page import="dataBase.dao.entity.EmployeeEntity"%>
<%@page import="java.util.List"%>
<%@page import="dataBase.EmployeeDaoImpl"%>
<%@page import="dataBase.EmployeeDao"%> --%>
<html>
<head>
<title>Show All Data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<!-- For DataTables -->
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
<!-- For DataTables -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- My Table name included in the <table> in ID section -->
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
	<header class = "header">
		<a href="logout"> <!-- Simple Button --> <!-- <button>Show Employees</button> -->
			<button type="button" class="btn btn-danger" style="position: absolute; top:5px; right: 10px;">LogOut</button>
		</a> <!-- Add a welcome message we the name in it --></header>
	
<br/>
<br/>
	<div class="container mb-3 mt-3">
	<font class="myTextStyle" face = "Showcard Gothic" size = "5" style="color: #00ffaca6; ">WARLIONS</font><br/><br/>
		<!--  margin bottom and margin top == 3-->
		<a href="showAllData.jsp"> <img src="Images/beatifulScene.jfif"
			style="height: 180px">
		</a>
		<hr />
		
		<!--****Make the connection to the preferred DataBase and Start Xamppp****  -->

	 <table id="myTable"
			class="table table-striped table-bordered sortable myFormStyle"  style="color:white" 
			>

			<thead>
				<tr>
					<th>Eid</th>
					<th>UserId</th>
					<th>Name</th>
					<th>Email</th>					
					<th>Mobile Number</th>
					
					
				</tr>
			</thead>
			
			<tbody> 
						<!-- Before learning Servlet, I did like this -->
		<%-- 	
			<%
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			List<EmployeeEntity> employeeList = new ArrayList<EmployeeEntity>();
			employeeList = employeeDao.findAll();

			for (EmployeeEntity employees : employeeList) {
			%>
			 --%>
						<!-- Before learning Servlet, I did like this -->
			
			<!-- <tbody> -->
			
			<!-- Before learning Servlet, I did like this -->
				<%-- <tr>
					<td><%=employees.geteID()%></td>
					<td><%=employees.getUserId()%></td>
					<td><%=employees.getName()%></td>
					<td><%=employees.getEmail()%></td>
					<td><%=employees.getMobile()%></td>
				</tr>
				<%
					}
				%> --%>
				
				<!-- Before learning Servlet, I did like this -->
				<!--*************************************************************  -->
				
				<!-- After learning Servlet, I did like this -->
				
				
			<c:forEach items = "${employeeList}" var = "entity" >
			
			
				<tr>
					<td>${entity.eID}</td>
					<td>${entity.userId}</td>
					<td>${entity.name}</td>
					<td>${entity.email}</td>
					<td>${entity.mobile}</td>
					

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
