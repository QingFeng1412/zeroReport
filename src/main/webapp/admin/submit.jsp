<%--
  Created by IntelliJ IDEA.
  User: fyl2003
  Date: 2022/9/23
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <title>提交</title>
</head>
<body>
<div style="margin-top: 16%">
<form action="${pageContext.request.contextPath}/submit" method="post">
    班级<input name="gradeAndClass">
    <br>

    情况<input name="inf" type="text">
    <br>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
