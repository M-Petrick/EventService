<?xml version="1.0" encoding="ISO-8859-1" ?>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
			<title>Event Lookup Service</title>
		</head>
	<body>
		<h1>Welcome to the Event Lookup Service</h1>
		<p>This is a list of current events:</p>
		<ul>
			<c:forEach items="${events}" var="event">
			<li>${event.name} - ${event.eventDateString}</li>
			</c:forEach>
		</ul>
		<p><a href="search">Search for an event.</a></p>
	</body>
</html>