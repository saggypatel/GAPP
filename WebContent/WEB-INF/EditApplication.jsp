<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<p><strong><a href="ApplicationList">CS Grad Admission</a> &gt; Edit Application</strong></p>

<form action="EditApplication" method="post">
Applicant: <input type="text" name="name" value="${applicant.name}"/> <br />
Application Recieved On(M/d/yyyy): <input type="text" name="date" value="${applicant.date}" /> <br />
gpa:<input type="text" name="gpa" value="${applicant.gpa}" /> <br />
Status:<select name="status">
			<option select="selected">${applicant.status}</option>
			<option>Application Incomplete</option>
			<option>Pending Review</option>
			<option>Rejected</option><option>Accepted</option>
			<option>Admission Offer Sent</option>
			<option>Admission Offer Accepted</option> 
		</select><br />
<input type="hidden" name="id" value="${applicant.id}" />
<input type="submit" name="save" value="Save" />
</form>

</body>
</html>