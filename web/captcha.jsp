<%-- 
    Document   : captcha
    Created on : Jun 9, 2017, 7:32:10 PM
    Author     : janardhan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<html>
<head>
<title>CAPTCHA in Java using reCAPTCHA</title>
</head>
<body>
<h2>CAPTCHA in Java Application using reCAPTCHA</h2>
<form action="/validate.jsp" method="post">
<p>Username: <input type="text" name="user"></p>
<p>Password: <input type="password" name="password"></p>
<p>
<%
	ReCaptcha c = ReCaptchaFactory.newReCaptcha(
       		  	"6LdlHOsSAAAAAM8ypy8W2KXvgMtY2dFsiQT3HVq-", 
        		"6LdlHOsSAAAAACe2WYaGCjU2sc95EZqCI9wLcLXY", false);
	out.print(c.createRecaptchaHtml(null, null));
%>
   <input type="submit" value="submit" />
</p>        
        </form>
</body>
</html>