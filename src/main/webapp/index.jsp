<%--
  Created by IntelliJ IDEA.
  User: fyl2003
  Date: 2022/9/19
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Document</title>
</head>
<body><form action="${pageContext.request.contextPath}/login" class="login" method="post">
    <p>Login</p>
    <input type="text" name="userId" placeholder="用户名">
    <input type="password" name="userPassword" placeholder="密码">
    <input type="submit" class="btn" value="登  录">
    ${msg}
</form>

</body>
<style>
    *{
        user-select: none;
        /* 无法选中，整体感更强 */
    }

    body{
        background-size: cover;
        background-attachment: fixed;
        background-image: url("img/p1.jpg");
        background-repeat: no-repeat;
    }

    .login{
        position: absolute;
        top: 50%;
        margin-top: -200px;
        left: 50%;
        margin-left: -200px;
        /* absolute居中的一种方法 */
        background-color: transparent;
        width: 400px;
        height: 400px;
        border: #59c2a0;
        border-radius: 25px;
        text-align: center;
        padding: 5px 40px;
        box-sizing: border-box;
        /* 这样padding就不会影响大小 */
    }

    p{
        font-size: 42px;
        font-weight: 600;
    }

    input{
        background-color: transparent;
        width: 100%;
        height: 48px;
        margin-bottom: 10px;
        border: 1px cyan;
        border-bottom: 2px solid silver;
        /* 下面的会覆盖上面的步伐 */
        outline: none;
        font-size: 22px;
    }

    .btn{
        background-color: #59c2c5;
        width: 38%;
        height: 48px;
        border-radius: 8px;
        margin-top: 40px;
        font-size: 28px;
        font-weight: 600;
        color: white;
    }
    .btn:hover{
        background-color: #59c2a0;
    }
</style>
</html>
