<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<html>
<body>
<% DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); %>
Current date = <%=df.format(new Date()) %>
</body>
</html>
