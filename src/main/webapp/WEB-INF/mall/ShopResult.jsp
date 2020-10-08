<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
mall\ShopResult.jsp
<br>
<a href="main.jsp">시작 페이지</a><br>
<h2 align="center">주문 상세 내역</h2>

<table border="1" align="center">
	<tr>
		<td colspan="2">고객 : ${loginInfo.name }</td>
		<td colspan="3">송장 번호 : ${oid }</td> 
	</tr>
	<tr>
		<td colspan="5">배송지 : ${loginInfo.address1 }&nbsp; ${loginInfo.address2 }</td> 
	</tr>
	<tr>
		<th>순번</th>
		<th>상품명(상품번호)</th>
		<th>수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	
	<c:forEach var="sinfo" items="${lists }" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${sinfo.pname}(${sinfo.pnum })</td>
			<td>${sinfo.qty}</td>
			<td><fmt:formatNumber value="${sinfo.price }" pattern="###,###"/></td>
			<td><fmt:formatNumber value="${sinfo.amount }" pattern="###,###"/></td>
		</tr>
	
	</c:forEach>
</table>