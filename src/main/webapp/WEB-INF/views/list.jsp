<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>List</h3>
	<table width="800" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.bid }</td>
				<td>${i.bname }</td>
				<td><c:set value="${i.bindent }" var="endindent" /> <c:forEach
						begin="1" end="${i.bindent }" var="cnt">
			&nbsp;
				<c:if test="${cnt eq endindent }">
							<img src="resources/img/icon_reply.gif" />[re]
				</c:if>
					</c:forEach> <a href="contentview?bid=${i.bid }">${i.btitle }</a>



				</td>
				<td>${i.bdate }</td>
				<td>${i.bhit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writerview">글쓰기</a></td>
		</tr>

	</table>
	총게시글 : ${totRowcnt }
	<br /> 현재 페이지/토탈페이지 : ${searchVO.page }/${searchVO.totPage }
	<br />
	<hr />

	<form action="list" method="post">

		<c:if test="${searchVO.page>1 }">
			<a href="list?page=1">[처음]</a>
			<a href="list?page=${searchVO.page-1 }">[이전]</a>
		</c:if>

		<c:forEach begin="${searchVO.pageStart }" end="${searchVO.pageEnd }"
			var="i">

			<c:choose>
				<c:when test="${i eq searchVO.page }">
					<span style="color: blue; font-weight: bold;">${i } &nbsp;</span>

				</c:when>
				<c:otherwise>
					<a href="list?page=${i } " style="text-decoration: none;">${i }</a>

				</c:otherwise>
			</c:choose>


		</c:forEach>

		<c:if test="${searchVO.page < searchVO.totPage }">
			<a href="list?page=${searchVO.page+1 }">[다음]</a>
			<a href="list?page=${searchVO.totPage }">[마지막]</a>

		</c:if>

		<div>
		<c:choose>
			<c:when test="${btitle }">
			<input type="checkbox" name="searchType" value="btitle" checked="checked"/> 
			</c:when>
			<c:otherwise>
			<input type="checkbox" name="searchType" value="btitle" />
			</c:otherwise>
		</c:choose>
		제목 
		<c:choose>
			<c:when test="${bcontent }">
			<input type="checkbox" name="searchType" value="bcontent" checked="checked"/>
			</c:when>
			<c:otherwise>
			<input type="checkbox" name="searchType" value="bcontent" />
			</c:otherwise>
		</c:choose>
		내용 
			<input type="text" name="sk" value="${resk }"/> <input type="submit" value="검색" />
		</div>

	</form>
</body>
</html>