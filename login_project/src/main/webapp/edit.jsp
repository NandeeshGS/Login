<%@page import="dto.Signuppage"%>
<%@page import="dao.SingupLogin"%>
<%@page import="controler.SaveUser" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); 
SingupLogin singupLogin=new SingupLogin();
Signuppage signuppage=singupLogin.find(id);
%>
<form action="update" method="post">
<label for="id">Id:</label>
<input type="text" name="id" value="<%=signuppage.getId() %>" readonly="readonly">
<label for="name">Name:</label>
<input type="text" name="name" value="<%=signuppage.getName() %>" required="required">
<label for="email">Email:</label>
<input type="email" name="email" value="<%=signuppage.getEmail() %>" required="required">
<label for="mobileno">Mobileno:</label>
<input type="tel" name="mobileno" value="<%=signuppage.getMobileno()%>" required="required" pattern="[0-9]{10}" maxlength="10">
<label for="password">Password:</label>
<input type="password" name="pass" value="<%=signuppage.getPassword() %> ">

<button type="submit">Update</button>
<button type="reset">Reset</button>
</form>
</body>
</html>