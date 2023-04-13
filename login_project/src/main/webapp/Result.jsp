<%@page import="dto.Signuppage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Signuppage> list= (List<Signuppage>) request.getAttribute("list"); %>

<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(Signuppage signuppage:list) {%>
<tr>
<th><%=signuppage.getId() %></tr>
<th><%=signuppage.getName() %></tr>
<th><%=signuppage.getEmail() %></tr>
<th><%=signuppage.getMobileno() %></tr>
<th><%=signuppage.getPassword() %></tr>
<th><a href="edit.jsp?id=<%=signuppage.getId() %>"><button>Edit</button></a></tr>
<th><a href="delet.jsp?id=<%=signuppage.getId() %>"><button>Delete</button></a></tr>
</tr>
<%} %>
</table>

</body>
</html>