<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set,java.util.List, com.yoriessence.shopping.vo.Product, java.util.Random" %>
<%
	List<Product> pd=(List<Product>)request.getAttribute("Product");
	Set<Product> rndPro=(Set<Product>)request.getAttribute("rndPro");
	int count=0;
%>
<%@ include file="/view/shopping/shoppingall.jsp" %>
	<div class="meaning">
		<div>
		<p class="text">오늘의 추천상품</p>
		<%for(Product pdt : rndPro) {%>
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
			<%
			
		}%>
		</div>
	</div>
	
	<div class="allpark">
		<p class="top">전체 상품</p>
			
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
			<%} %>
			
	
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<div id="pageBar">
	       &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      	<%=request.getAttribute("pageBar") %>
	    </div>
	</div>
	
	
	
	
	
<%@ include file="/view/common/footer.jsp"%>







































