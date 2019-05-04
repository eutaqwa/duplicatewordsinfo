<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Koreksi kata berulang</title>
</head>
<body>
	<h1><font size="8" face="Century, Arial" color="green">Manipulation, Find, and Information of Duplicated Words</font><font size="9" face="Century, Arial" color="black"> </font></h1>
	<hr/>
	<form name="MyFrom" action="Main" method="post">
		<table>	 
		<tbody>
			<tr>
				<td><code>Input   :</code></td>
				<td><input type="text" placeholder="masukan input berupa kata-kata" value="" name="input" size="50" /></td>
			</tr>

			<tr>
				<td><code>Output:</code></td>
				<td><input type="text" name="second" value="<%= request.getAttribute("nama")%>" size="100" placeholder="output" maxlength="100"/></td>
			</tr>
		</tbody>
		</table>
				<input type="submit" value="Save" name="filter" />
				
	</form>
</body>
</html>