<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--引入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<!--添加背景图片-->
<body background="image/success.jpg">

<div style="margin: auto">
<div>
    <%--利用jstl标签获取session中的user的值--%>
    <strong style="font-size: 100px;color: red"> ${sessionScope.user.username}!</strong>
    <strong style="font-size: 100px;color: blue"> ，你他妈登录成功了</strong>
</div>

<form action="/LoginDemo/outLogin" >
    <button type="submit" class="btn btn-success col-lg-12" style="font-size: 100px;text-align: center">退出登录</button>
</form>

</div>
</body>
</html>
