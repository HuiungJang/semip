<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.yoriessence.shopping.vo.Product, java.util.Random" %>
<%
	List<Product> pd=(List<Product>)request.getAttribute("kategori");
%>
<%@ include file="/view/shopping/shoppingall.jsp" %>
<style>
	.top2{
		/* border-top:8px black solid; */
		width:1500px;
	}
</style>


<!-- 
	추천상품의 경우는 랜덤요소로 넣으면 편리할거같음 랜덤요소 추가햇지만 쿠키나 세션에 저장을해서 보내야할거같음
	음식 태그 선택시 해당태그의 음식을 전체상품으로 출력해야함
	상품 이미지 클릭시 해당상품 구매페이지로 이동
-->
	<div class="meaning">
		<div class="allpark">
			<p class="top2">전체 상품</p>
				<%for(Product pdt : pd) {%>
				<ul class="test">
					<li>
						<a href="<%=request.getContextPath()%>/shopping/shopping?productNo=<%=pdt.getProductNo()%>">
							<input type="hidden" value="<%=pdt.getProductNo() %>">
							<img src="<%=request.getContextPath() %>/image/<%=pdt.getProductImage() %>" alt="" class="shop">
						</a>
					</li>
					<li class="jsp">제품명 :<%=pdt.getProductName() %></li>
					<li class="jsp">가격 :<%=pdt.getPrice() %></li>
				</ul>
				<%}%>
		</div>
	</div>