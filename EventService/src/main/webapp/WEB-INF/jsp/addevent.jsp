<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
		  xmlns:h="http://java.sun.com/jsf/html"
      	  xmlns:f="http://java.sun.com/jsf/core"
      	  xmlns:c="http://java.sun.com/jsp/jstl/core">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Add Event</title>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	    <style>
	      body { background-color: #eee; font: helvetica; }
	      #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
	      .green { font-weight: bold; color: green; }
	      .message { margin-bottom: 10px; }
	      label {width:140px; display:inline-block;}
	      form {line-height: 160%; }
	      .hide { display: none; }
	    </style>
	</head>
	<body>
		<div id="container">	
			<h1>Add an event</h1>
	
			<form:form modelAttribute="event"
			           method="post">
			    <table>
				    <tr>
				        <td><form:label path="name">Event name</form:label></td>
				        <td><form:input path="name"/></td>
				    </tr>  	      
			   		<tr>
				        <td><form:label path="eventDate">Event date</form:label></td>
				        <td><form:input path="eventDate"/></td>
				    </tr> 
				    <tr>
				        <td><form:label path="location">Event location</form:label></td>
				        <td><form:input path="location"/></td>
				    </tr> 
				    <tr>
				        <td><form:label path="description">Event description</form:label></td>
				        <td><form:textarea id="tinyeditor" path="description" rows="5" cols="30" /></td>
				    </tr> 
				    <tr>
				        <td><form:label path="eventWebSite">Event web site</form:label></td>
				        <td><form:input path="eventWebSite"/></td>
				    </tr> 
					<tr>
				        <td><input type="submit" value="Add Event" /></td>
				        <td></td>
				    </tr>	
				</table>		   
			</form:form> 
		</div>
		
	
		<script type="text/javascript">
			new TINY.editor.edit('editor',{
				id: 'tinyeditor',
				width: 584,
				height: 175,
				cssclass: 'tinyeditor',
				controlclass: 'tinyeditor-control',
				rowclass: 'tinyeditor-header',
				dividerclass: 'tinyeditor-divider',
				controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|',
					'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign',
					'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n',
					'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'print'],
				footer: true,
				fonts: ['Verdana','Arial','Georgia','Trebuchet MS'],
				xhtml: true,
				cssfile: 'custom.css',
				bodyid: 'editor',
				footerclass: 'tinyeditor-footer',
				toggle: {text: 'source', activetext: 'wysiwyg', cssclass: 'toggle'},
				resize: {cssclass: 'resize'}
			});
		    		  
		</script>	
	</body>
</html>