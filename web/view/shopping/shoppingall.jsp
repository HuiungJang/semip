<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/common/header.jsp"%>
<div>
	<form action="<%=request.getContextPath() %>/shopping/search">
		<input type="text" name="search" class="search" size="38" placeholder="검색할 상품을 입력하세요">
		<button type="submit" class="search2">검색</button>
	</form>
	<table id="tr">
		<tr>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="일식">
				<input type="submit" class="underlines" value="일식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="중식">
				<input type="submit" class="underlines" value="중식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="양식">
				<input type="submit" class="underlines" value="양식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="한식">
				<input type="submit" class="underlines" value="한식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="과자">
				<input type="submit" class="underlines" value="과자">
			</td>
			</form>
		</tr>
	</table>
</div>















































