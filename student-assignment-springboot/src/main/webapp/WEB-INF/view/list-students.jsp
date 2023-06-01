<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2><font color='red'>Student Assignment</font></h2>
			<hr />
				<input type="button" value="Add Student"onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
				<br/><br/>
			
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title"><h2>Student Detail<h2></div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered ">
						<tr>
							<th>Name</th>
							<th>Entering Date</th>
							<th>Nationality</th>
							<th>code</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tempStudentList" items="${student}">

							<!-- construct an "update" link with Student id -->
							<c:url var="updateLink" value="/updateForm">
								<c:param name="studentId" value="${tempStudentList.studentId}" />
							</c:url>
							<!-- construct an "delete" link with Student id -->
							<c:url var="deleteLink" value="/delete">
								<c:param name="studentId" value="${tempStudentList.studentId}" />
							</c:url>
							<!-- construct an "FindByName" link with Student Name -->
							<tr>
							
								<td>${tempStudentList.name}</td>
								<td>${tempStudentList.enteringDate}</td>
								<td>${tempStudentList.nationality}</td>
								<td>${tempStudentList.code}</td>

								<td>
									<!-- display the update link -->
									 <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>
					<br></br>
					
		
					<input type="button" value="FindByID"  onclick="window.location.href='findStudentById';return false;"
				class="btn btn-primary" />
				<br></br>
				<input type="button" value="FindByName" onclick="window.location.href='findByName';return false;"
				class="btn btn-primary" />
				<br></br>
				<input type="button" value="Delete All Student"onclick="window.location.href='deleteAll'; return false;"
				class="btn btn-primary" />
				<br/></br>

				</div>
			</div>
		</div>

	</div>
</body>
</html>

