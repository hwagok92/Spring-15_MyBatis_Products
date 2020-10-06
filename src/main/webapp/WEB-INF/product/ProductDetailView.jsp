<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>상품 상세 화면 ${product.num }</h2>

<table border=1>
	<tr>
		<td><img src="<%=request.getContextPath() %>/resources/${product.image}" width="100px" height="100px"></td>

		<table border="1">
			<tr>
				<td width="150">상품명</td>
				<td width="300">${product.name }</td>
			</tr>
			<tr>
				<td width="150">가격</td>
				<td width="300">${product.price }</td>
			</tr>
			<tr>
				<td width="150">재고 수량</td>
				<td width="300">${product.stock }</td>
			</tr>
			<tr>
				<td width="150">설명</td>
				<td width="300">${product.contents }</td>
			</tr>
			<tr>
				<td width="150">주문 수량</td>
				<td width="300">
					<form action="" method="post">
						<input type="text" name="orderqty" value="1">
						<input type="submit" value="주문">
					</form>
				</td>
			</tr>
			<tr colspan="2" align="center">
				<a href="list.prd">상품 리스트</a>
			</tr>
		</table>
	</tr>

</table>