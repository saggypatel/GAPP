<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Application List</title>
</head>
<body>

<p><strong>CS Grad Admission</strong></p>


<a href="AddApplication">Add New Application</a><br /><br />

<table border="1">
  <tr>
  <th><a href="SortBy?column=name">Applicant</a></th>
  <th><a href="SortBy?column=date">Application Received On</a></th>
  <th><a href="SortBy?column=gpa">GPA</a></th>
  <th><a href="SortBy?column=status">Status</a></th>
  </tr>

	<c:forEach items="${applicants}" var="applicant">
	  <tr>
	    <td>${applicant.name}</td>
	    <td>${applicant.date}</td>
	    <td>${applicant.gpa}</td>
	    <td>${applicant.status}</td>
	    <td><a href="EditApplication?id=${applicant.id}">Edit</a></td>
	  </tr>
	</c:forEach>
</table>

</body>
</html>