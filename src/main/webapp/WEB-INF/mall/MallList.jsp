<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp"%>
<h2 align="center">주문 내역</h2>
<table border=1 align="center">
	<tr>							<!--sessionScope는 생략 가능  -->
		<td colspan="5" align="center">주문자 정보 : ${sessionScope.loginInfo.name }(${sessionScope.loginInfo.id })</td>
	</tr>

	<tr>
		<th align="center">상품 번호</th>
		<th align="center">상품명</th>
		<th align="center">주문 수량</th>
		<th align="center">단가</th>
		<th align="center">금액</th>
	</tr>
									<!--sessionScope는 생략 가능  -->
		<c:forEach var="shoplists" items="${shoplists }">
			<tr>
				<td align="center">${shoplists.pnum }</td>
				<td align="center">${shoplists.pname }</td>
				<td align="center">${shoplists.qty }</td>
				<td align="center">${shoplists.price }</td>
				<td align="center">${shoplists.amount }</td>
			</tr>
		</c:forEach>
	
	<tr>
		<td colspan="3" align="center">
			<a href="calculate.mall">결재하기</a>
			<a href="list.prd">추가주문</a>
		</td> 

		<td colspan="2" align="center">총금액 : ${totalAmount }</td>
	</tr>
</table>


