<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/nstyle.css" />
</head>
<body>
<h3>writer</h3>
<form action="write" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td class="left">이름</td>
			<td><input type="text" name="bname" value="jj" /></td>
		</tr>
		<tr>
			<td class="left">제목</td>
			<td><input type="text" name="btitle" value="jj" /></td>
		</tr>
		<tr>
			<td class="left">내용</td>
			<td> <textarea name="bcontent" rows="10">내용을쓰세요.</textarea> </td>
		</tr>
		<tr>
			<td class="left">첨부</td>
			<td> <input type="file" name="file" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit"  value="입력" />
			<a href="list">목록</a>
			
			</td>
			
		</tr>
	
	
	
	</table>



</form>



</body>
</html>