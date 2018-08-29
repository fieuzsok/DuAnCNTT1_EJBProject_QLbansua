<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách loại sữa</title>
</head>
<body>
<table border="1">
<caption>Danh sach loai sua</caption>
	<tr>
		<th>ma</th>
		<th>Ten</th>
	</tr>
	<c:forEach items="${dsls}" var="ls">
		<tr>
			<td>${ls.ma_loai_sua}</td>
			<td>${ls.ten_loai_sua}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>