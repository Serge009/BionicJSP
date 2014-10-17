<%--
  Created by IntelliJ IDEA.
  User: oper4
  Date: 17.10.2014
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="create_depo" method="post">
        <input type="text" name="bank" placeholder="bank"/>
        <input type="text" name="depoId" placeholder="depo id"/>
        <input type="date" name="startDate" placeholder="start date"/>
        <input type="number" min="1" name="dayLong" placeholder="day long"/>
        <input type="number" min="100" name="sum" placeholder="sum"/>
        <input type="number" min="0" step="0.1" name="interestRate" placeholder="interest rate"/>
        <input type="radio" name="simple" />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
