<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Set,java.util.List, com.yoriessence.shopping.vo.Product, java.util.Random" %>
<%
	List<Product> pd=(List<Product>)request.getAttribute("Product");
	Set<Product> rndPro=(Set<Product>)request.getAttribute("rndPro");
	int count=0;
%>
<%@ include file="/view/shopping/shoppingall.jsp" %>
<div class="todayProductContainer">
	<div class="text">오늘의 추천상품</div>
		<%for(Product pdt : rndPro) {%>
		<div>
			<div class="productContent">
				<span>
					<a href="<%=request.getContextPath()%>/shopping/shopping?productNo=<%=pdt.getProductNo()%>">
						<input type="hidden" value="<%=pdt.getProductNo() %>">
						<img src="<%=request.getContextPath() %>/image/<%=pdt.getProductImage() %>" alt="" class="shop"
						style="width: 250px; height:250px;">
					</a>
				</span>
				<span class="jsp">제품명 :<%=pdt.getProductName() %></span><br>
				<span class="jsp">가격 :<%=pdt.getPrice() %></span>
			</div>
		</div>
		<%}%>
</div>
<div class="allProductContainer">
	<div class="text">전체상품조회</div>
<%--	<%for(Product pdt : pd) {%>--%>
<%--		<div class="totalProductContainer">--%>
<%--			<span><a href="<%=request.getContextPath()%>/shopping/shopping?productNo=<%=pdt.getProductNo()%>">--%>
<%--						<input type="hidden" value="<%=pdt.getProductNo() %>">--%>
<%--						<img src="<%=request.getContextPath() %>/image/<%=pdt.getProductImage() %>" alt="" class="shop" style="width: 250px; height:250px;"></a>--%>
<%--			</span>--%>
<%--			<span>제품명 :<%=pdt.getProductName() %></span><br>--%>
<%--			<span>가격 :<%=pdt.getPrice() %></span>--%>
<%--		</div>--%>
<%--	<%}%>--%>
<%--	<div id="pageBar">--%>
<%--		<div><%=request.getAttribute("pageBar") %></div>--%>
<%--	</div>--%>
</div>
<script>
	let listCount = 0;

	$(function(){
		let target = $('.allProductContainer');
		let winTop;
		let onTop;

		function getList(){

			$.ajax({
				url: '<%=request.getContextPath()%>/getMallData',
				data:{
					"cPage":listCount
				},
				success:data=>{
					let getData='';
					// $('.allProductContainer *').remove();
					console.log(data);

					$(data).each((i,v)=>{
						getData = '<div class="totalProductContainer">';
						getData += '<span><a href="<%=request.getContextPath()%>/shopping/shopping?productNo='+v.productNo+'">';
						getData += '<input type="hidden" value="'+v.productNo+'">';
						getData += '<img src="<%=request.getContextPath() %>/image/'+v.productImage+'" alt="" class="shop" style="width: 250px; height:250px;"></a></span>';
						getData += '<span>제품명 :'+v.productName+'</span><br>';
						getData += '<span>가격 :'+v.price+'</span>';
						getData += '</div>';

						// console.log(getData);
						$(".allProductContainer").append(getData);
					});
				}
			});

			listCount++;
		}


		function listCall(){
			winTop =$(window).scrollTop();
			onTop=$(document).height() - $(window).height() - $('.footer').height();

			console.log(winTop);
			console.log(onTop);


			if(winTop>=onTop){
				getList();
			}
		}


		$(window).scroll(function(){
			listCall();
		});

	});
</script>

<%@ include file="/view/common/footer.jsp"%>

	







































