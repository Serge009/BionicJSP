<%@ page import="app.DepoBase" %>
<%@ page import="java.util.List" %>
<% List<DepoBase> list = (List<DepoBase>) session.getAttribute("deposits"); %>
<%--
  Created by IntelliJ IDEA.
  User: oper4
  Date: 17.10.2014
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="depo.css" />
</head>
<body>
<table>
    <tr>
        <td>Start</td>
        <td>Long</td>
        <td>Sum</td>
        <td>Interest Rate</td>
    </tr>
    <% for (DepoBase d : list) { %>

    <%=(d.getDataForWeb())%>

    <%} %>
</table>
</body>
</html>
