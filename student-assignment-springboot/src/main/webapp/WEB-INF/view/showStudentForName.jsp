<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring-Hibernate</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Find Student By Name</h2>
			<div class="panel panel-info">
				<div class="panel-body">
					<form:form action="showFormForName" cssClass="form-horizontal"
						method="post" modelAttribute="student">

						<div class="form-group">
							<table class="table table-striped table-bordered">
								<tr>
									<td>
										<label for="name" class="col-md-3 control-label">Enter Student Name </label>
									</td>
									<td>
										<form:input path="name" cssClass="form-control" />
									</td>
								</tr>
								
							</table>
							 
							<!-- need to associate this data with Student name -->
							
						</div>
				<br></br>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary" >Student Details </form:button>
						<table class="table table-striped table-bordered ">
						<tr>
							<th>Name</th>
							<th>Entering Date</th>
							<th>Nationality</th>
							<th>code</th>
						</tr>
				<c:forEach var="tempStudentList" items="${students}">
						<tr>
							
								<td>${tempStudentList.name}</td>
								<td>${tempStudentList.enteringDate}</td>
								<td>${tempStudentList.nationality}</td>
								<td>${tempStudentList.code}</td>
						</tr>
				</c:forEach>
						</table>
							</div>
						</div>
						
			<br></br>
						<div class="panel-body">		
							<a href="${"/"}">Return Home Page</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>