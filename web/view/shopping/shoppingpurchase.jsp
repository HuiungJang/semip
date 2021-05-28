<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.shopping.vo.Product" %>
<%
	Product pd=(Product)request.getAttribute("product");
%>
<%@ include file="/view/shopping/shoppingall.jsp" %>

<style>
	.shopimg{
		height:600px;
		width:600px;
		margin-left:350px;
		margin-top:300px;
	}
	.shop{
		width:100;
		height:100;
		margin-left:350px;
		float: left;
	}
	.container{
		display: flex;
		font-size:38px;
	}
	.margin{
		margin-top:300px;
		margin-left:100px;
		font-size:38px;
	}
	#su{
		 font-size:25px;
		 width:200px;
	}
	.margin2>li{
		margin-bottom:50px;
	}
	.pont{
		font-size:38px;
		
	}
	div#comment-container button#btn-insert{
		width:60px;height:50px; 
		color:black;
	    background-color:#8CC7BC;
	    position:relative;
	    top:-20px;
    }
    div#comment-container{
    	text-align:center;
    	 position:relative;
	    top:120px;
    }
    #content{
    	width:900px;
    }
</style>
	<div  class="container">
		<div>
			<ul>
				<li>
					<img src="<%=request.getContextPath() %>/image/<%=pd.getProductImage() %>" alt="" class="shopimg">
				</li>
			</ul>
		</div>
		<div class="margin">
			<form action="<%=request.getContextPath() %>/insertcart" method="get">
				<ul class="margin2">
					<li>
						상품명 :<%=pd.getProductName() %>
						<input type="hidden" name="productno" value=<%=pd.getProductNo() %>>
						<input type="hidden" name="productname" value=<%=pd.getProductName() %>>
					</li>
					<li>
						상품설명 :<%=pd.getExplanation() %>
						<input type="hidden" name="productexplanation" value=<%=pd.getExplanation() %>>
					</li>
					<li>
						가격 :<%=pd.getPrice() %>
						<input type="hidden" name="productprice" value=<%=pd.getPrice() %>>
					</li>
					<li>수량 :
						<input type="number" id="su" name="su" max=<%=pd.getStock() %> min=0 value=0>
					</li>
					<li>
						배송비 :<%=pd.getProductshopify() %>
						<input type="hidden" name="productshopify" value=<%=pd.getProductshopify() %>>
					</li><br>
					<li>
						<button onclick="test();" class="pont">바로주문</button>
						<button type="submit" id="gocart" class="pont">장바구니</button>
					</li>
				</ul>
			</form>
		</div>
	</div>
		
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>	    	
<script>
	function test()	{
		const su = document.getElementById('su').value;
		var IMP = window.IMP; // 생략가능
		IMP.init('iamport'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
		    pg : 'kakao', // version 1.1.0부터 지원.
		    /*
				'kakao':카카오페이,
				html5_inicis':이니시스(웹표준결제)
				'nice':나이스페이
				'jtnet':제이티넷
				'uplus':LG유플러스
				'danal':다날
				'payco':페이코
				'syrup':시럽페이
				'paypal':페이팔
			*/
		    pay_method : 'card',
		    /*
				'samsung':삼성페이,
				'card':신용카드,
				'trans':실시간계좌이체,
				'vbank':가상계좌,
				'phone':휴대폰소액결제
			*/
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '주문명:<%=pd.getProductName()%>',
		    /* 결제창에서 보여질 이름 */
		    amount : (<%=pd.getPrice()%>*su)+<%=pd.getProductshopify()%>,
		    /* 가격 */
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456',
		    m_redirect_url : 'https://www.yourdomain.com/payments/complete'
		    /*
		    	모바일 결제시,
		    	결제가 끝나고 랜딩되는 URL을 지정
		    	(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
		    */
		}, function(rsp) {
		    if ( rsp.success ) {
		        var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
	}
</script>

	

<%@ include file="/view/common/footer.jsp"%>