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
<h3>reply_view</h3>

<form action="reply" method="post">


<input type="hidden" name="bid" value="${reply_view.bid }" />
<input type="hidden" name="bgroup" value="${reply_view.bgroup }" />
<input type="hidden" name="bstep" value="${reply_view.bstep }" />
<input type="hidden" name="bindent" value="${reply_view.bindent }" />
	<table>
	
		<tr>
			<td class="left">번호</td>
			<td>${reply_view.bid }</td>
		</tr>
		<tr>
			<td class="left">조회수</td>
			<td>${reply_view.bhit }</td>
		</tr>
		<tr>
			<td class="left">이름</td>
			<td>
				<input type="text" name="bname" value="${reply_view.bname }" />
			</td>
		</tr>
		<tr>
			<td class="left">제목</td>
			<td>
				<input type="text" name="btitle" value="${reply_view.btitle }" />
			</td>
		</tr>
		<tr>
			<td class="left">내용</td>
			<td>
				<textarea name="bcontent" rows="10">${reply_view.bcontent }</textarea> 
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input type="submit" value="등록" /></a> &nbsp;&nbsp;
			<a href="list">목록</a> &nbsp;&nbsp;
			
			
			
			
			</td>
			
		</tr>

	</table>
</form>
	
	
</body>
</html>