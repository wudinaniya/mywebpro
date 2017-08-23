<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>用户名</td>
			<td>提交日期</td>
			<td>证件类型</td>
			<td>审核结果</td>
			<td>审核人</td>
		</tr>
		<c:forEach items="${usermutates }"  var="usermutate">
			<tr>
				<td>${usermutate.username }</td>
				<td>${usermutate.submitDate }</td>
				<td>${usermutate.certiType }</td>
				<td>${usermutate.result }</td>
				<td>${usermutate.vid }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>