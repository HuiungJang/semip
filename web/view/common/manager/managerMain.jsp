<%@ page import="com.yoriessence.manager.model.vo.ManagerPage" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/27
  Time: 9:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%
    List<ManagerPage> getOrderList =  (List<ManagerPage>)request.getAttribute("getOrderList");

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/common/header.jsp"%>
<link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/view/common/css/managerPage.css" />
<script>
  $(function(){

    $("#sortRef").click((e)=>{
      $(".sortRef").css("display","grid")
      $(".sortRef2").css("display","none")
      $(".sortRef3").css("display","none")
    });

    $("#sortRef2").click((e)=>{
      $(".sortRef").css("display","none")
      $(".sortRef2").css("display","grid")
      $(".sortRef3").css("display","none")
    });

    $("#sortRef3").click((e)=>{
      $(".sortRef").css("display","none")
      $(".sortRef2").css("display","none")
      $(".sortRef3").css("display","grid")
    });

  });
</script>

<div id="managerContainer">
    <div class="managerTitle">
        <div>주문 통합조회</div>
    </div>
    <div class="controlPanel">
        <div class="largeSort">
            <div>
                <a id="sortRef">주문 현황별 조회</a>
            </div>
            <div>
                <a id="sortRef2">배송 현황별 조회</a>
            </div>
            <div>
                <a id="sortRef3">개별 조회</a>
            </div>
        </div>
<%--        주문 현황별 조회--%>
        <div class="sortRef">
            <div>
                <div>결제수단</div>
            </div>
            <div class="paymentMethod">
                <div><input type="radio" name="paymentMethod">전체</div>
                <div><input type="radio" name="paymentMethod">카드</div>
                <div><input type="radio" name="paymentMethod">무통장</div>
                <div><input type="radio" name="paymentMethod">계좌이체</div>
                <div><input type="radio" name="paymentMethod">휴대폰</div>
            </div>
            <div>
                <div>주문현황</div>
            </div>
            <div class="orderState">
                <select name="orderState" class="orderStateSelect">
                    <option>결제완료</option>
                    <option>입금대기</option>
                    <option>승인대기</option>
                    <option>취소</option>
                    <option>부분 취소</option>
                    <option>반품 신청</option>
                    <option>반품 진행중</option>
                    <option>반품 완료</option>
                    <option>교환신청</option>
                    <option>교환완료</option>
                    <option>구매완료</option>
                </select>
            </div>
            <div>
                <div>요청사항</div>
            </div>
            <div class="request">
                <div><input type="checkbox" value="refund">반품 요청</div>
                <div><input type="checkbox" value="exchange">교환요청</div>
            </div>
            <div>
                <div>조회일자</div>
            </div>
            <div class="searchDate">
                <div><input type="date" class="startDate"> ~</div>
                <div> <input type="date" class="endDate"></div>
                <div>
                    <input type="button" value="당일">
                    <input type="button" value="1주일">
                    <input type="button" value="당월">
                    <input type="button" value="2개월">
                    <input type="button" value="5개월">
                </div>
            </div>
            <div>
                <div>정렬</div>
            </div>
            <div class="sortMethod">
                <div><input type="radio" name="sortMethod">오름차순</div>
                <div><input type="radio" name="sortMethod">내림차순</div>
            </div>
        </div>
<%--        주문 현황별조회 끝--%>

<%--        배송현황별 조회--%>
        <div class="sortRef2" style="display: none">
            <div>
                <div>배송상태</div>
            </div>
            <div class="deliveryState">
                <div><input type="radio" name="deliveryState" value="all">전체</div>
                <div><input type="radio" name="deliveryState" value="ready">배송준비</div>
                <div><input type="radio" name="deliveryState" value="ing">배송중</div>
                <div><input type="radio" name="deliveryState" value="finish">배송완료</div>
            </div>
            <div>
                <div>배송시작</div>
            </div>
            <div class="searchDate">
                <div><input type="date" class="startDate"> ~</div>
                <div> <input type="date" class="endDate"></div>
                <div>
                    <input type="button" value="당일">
                    <input type="button" value="1주일">
                    <input type="button" value="당월">
                    <input type="button" value="2개월">
                    <input type="button" value="5개월">
                </div>
            </div>
            <div>
                <div>정렬</div>
            </div>
            <div class="sortMethod">
                <div><input type="radio" name="sortMethod">오름차순</div>
                <div><input type="radio" name="sortMethod">내림차순</div>
            </div>
        </div>
<%--        배송현황별 조회 끝--%>

<%--        개별 조회--%>
        <div class="sortRef3" style="display: none">
            <div>
                <div>조회일자</div>
            </div>
            <div class="searchDate">
                <div><input type="date" class="startDate"> ~</div>
                <div> <input type="date" class="endDate"></div>
                <div>
                    <input type="button" value="당일">
                    <input type="button" value="1주일">
                    <input type="button" value="당월">
                    <input type="button" value="2개월">
                    <input type="button" value="5개월">
                </div>
            </div>
            <div>
                <div>검색조건</div>
            </div>
            <div class="searchCondition">
                <div><input type="radio" name="searchCondition" value="orderNum">주문번호</div>
                <div><input type="radio" name="searchCondition" value="memberName">구매자명</div>
                <div><input type="radio" name="searchCondition" value="memberId">회원아이디</div>
                <div><input type="radio" name="searchCondition" value="productName">상품명</div>
            </div>
            <div>
                <div>정렬</div>
            </div>
            <div class="sortMethod">
                <div><input type="radio" name="sortMethod">오름차순</div>
                <div><input type="radio" name="sortMethod">내림차순</div>
            </div>
        </div>
<%--        개별 조회 끝--%>
        <div class="searchBtn">
            <div>
                <input type="button" value="조회">
            </div>
        </div>
    </div>
    <div class="managerContent">
<%--        <div class="selectAll">--%>
<%--            <input type="checkbox">전체선택--%>
<%--        </div>--%>
<%--        <div class="blank"> </div>--%>
<%--        <div class="selectDelivery">--%>
<%--            <select name="selectDelivery">--%>
<%--                <option>주문현황</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div class="selectN">--%>
<%--            <select name="selectN">--%>
<%--                <option>전체</option>--%>
<%--                <option>배송준비</option>--%>
<%--                <option>배송중</option>--%>
<%--                <option>배송완료</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div class="changeBtn">--%>
<%--            <button>선택항목 변경</button>--%>
<%--        </div>--%>
<%--        <div>선택</div>--%>
<%--        <div>번호</div>--%>
<%--        <div>주문번호</div>--%>
<%--        <div>구매자명</div>--%>
<%--        <div>금액</div>--%>
<%--        <div>결제수단</div>--%>
<%--        <div>주문현황</div>--%>
<%--        <div>배송현황</div>--%>
<%--        <div>결제일</div>--%>
<%--        <div>운송장</div>--%>
<%--        <%if(getOrderList != null){%>--%>
<%--            <%for(ManagerPage m:getOrderList){%>--%>
<%--                <div><input type="checkbox" class="checkRow"></div>--%>
<%--                <div><%=m.getRowNum()%></div>--%>
<%--                <div><%=m.getOrderNumber()%></div>--%>
<%--                <div><%=m.getMemberName()%></div>--%>
<%--                <div><%=m.getAmountPrice()%></div>--%>
<%--                <div><%=m.getPayment()%></div>--%>
<%--                <div><%=m.getPaymentStatus()%></div>--%>
<%--                <div><%=m.getShippingStatus()%></div>--%>
<%--                <div><%=m.getPaymentDate()%></div>--%>
<%--                <div><%=m.getWaybill()%><button class="inputWaybill">운송장입력하기</button></div>--%>
<%--            <%}%>--%>
<%--        <%}%>--%>
        <div id="sortNavi">
            <div class="selectAll">
                <input type="checkbox">전체선택
            </div>
            <div></div>
            <div class="selectDelivery">
                <select name="selectDelivery">
                    <option>주문현황</option>
                </select>
            </div>
            <div class="selectN">
                <select name="selectN">
                    <option>전체</option>
                    <option>배송준비</option>
                    <option>배송중</option>
                    <option>배송완료</option>
                </select>
            </div>
            <div class="changeBtn">
                <button>항목 변경</button>
            </div>
        </div>

    <%if(getOrderList != null){%>
        <%for(ManagerPage m:getOrderList){%>
            <div class="data">
                <div><input type="checkbox" class="checkRow"></div>
                <div><%=m.getRowNum()%></div>
                <div><%=m.getOrderNumber()%></div>
                <div><%=m.getMemberName()%></div>
                <div><%=m.getAmountPrice()%></div>
                <div><%=m.getPayment()%></div>
                <div><%=m.getPaymentStatus()%></div>
                <div><%=m.getShippingStatus()%></div>
                <div><%=m.getPaymentDate()%></div>
                <div><%=m.getWaybill()%>
                    <button class="inputWaybill">운송장입력하기</button>
                </div>
            </div>
         <%}%>
    <%}%>


    </div>
    <div class="pageBar">
        <div>
            <%=request.getAttribute("pageBar")%>
        </div>
    </div>
</div>
<script>
    'use strict;'

    function checkbox(){
      if($(".selectAll>input:selected")){
        $(".checkRow").attr("checked",true);
      }else{
        $(".checkRow").attr("checked",false);
      };
    };

    $(".selectAll>input").click(e=>{
      checkbox();
    })


</script>
<%@ include file="/view/common/footer.jsp"%>

