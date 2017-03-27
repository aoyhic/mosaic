<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

<a href="/city/register" class="btn btn-warning">city등록</a>
<button type="button" class="btn btn-primary">City Page <span class="badge">pageNo=${page.paging.pageNo}</button>
<div class="table-responsive">
<table class="table">
<thead>
<tr class="info">
<th>수정</th>
<th>삭제</th>
<th>No</th>
<th>CityName</th>
<th>CountryCode</th>
<th>district</th>
<th>Population</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<ol class="list-group">
<li>
	<c:forEach var="city" items="${page.citys}">
		<tr>
		<!-- 현재 어떤 페이지에서 어떤 로우를 수정했는지 쿼리스트링 형태로 넘겨주는 것 jsp에서 처리함  -->
		<td><button class="btn btn-default"><a href="/city/modify/${city.id}?pageNo=${page.paging.pageNo}">수정</a></button></td>
		<td><button class="btn btn-default"><a href="/city/unregister/${city.id}?pageNo=${page.paging.pageNo}">삭제</a></button></td> 
		<td>${city.id}</td>
		<td><a href="/city/item/${city.id}?pageNo=${page.paging.pageNo}"> ${city.name}</a></td> 
		<td>${city.countryCode}</td>
		<td>${city.district}</td>
		<td>${city.population}</td>
		 </li>
	</c:forEach>
</ol>
</tr>
</tbody>
</table></div>
<hr class="animated bounce">
<ul class="pagination">
<li><a href="/city/page/1">First</a></li>
<li><a href="/city/page/${page.paging.firstPage - 1}">Prev</a></li>
<li><c:forEach var="i" begin="${page.paging.firstPage}" end="${page.paging.lastPage}">
	<a href="/city/page/${i}">${i}</a>
</c:forEach></li>
<li><a href="/city/page/${page.paging.lastPage + 1}">Next</a></li>
<li><a href="/city/page/${page.paging.totalPage}">Last</a></li>
</ul>






</body>
</html>