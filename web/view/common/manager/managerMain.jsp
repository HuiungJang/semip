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
                <div><input type="radio" name="paymentMethod" value="all">전체</div>
                <div><input type="radio" name="paymentMethod" value="card">카드</div>
                <div><input type="radio" name="paymentMethod" value="book">무통장</div>
                <div><input type="radio" name="paymentMethod" value="account">계좌이체</div>
                <div><input type="radio" name="paymentMethod" value="phone">휴대폰</div>
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
                <div class="dateButton">
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
                <div class="dateButton">
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
                <div class="dateButton">
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
                <div><input type="text"  class="searchVal" placeholder="검색값을 입력하세요"></div>
            </div>
            <div>
                <div>정렬</div>
            </div>
            <div class="sortMethod">
                <div><input type="radio" name="sortMethod" value="asc">오름차순</div>
                <div><input type="radio" name="sortMethod" value="desc">내림차순</div>
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
        <div id="sortNavi">
            <div></div>
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
        <div class="rowTitle">
            <div class="selectAll">
                <input type="checkbox">전체선택
            </div>
            <div>번호</div>
            <div>주문번호</div>
            <div>주문자명</div>
            <div>가격</div>
            <div>결제방법</div>
            <div>배송상태</div>
            <div>결제일자</div>
            <div>송장번호</div>
        </div>
        <%if(getOrderList != null){%>
        <%for(ManagerPage m:getOrderList){%>
        <div class="data">
            <div><input type="checkbox" class="checkRow"></div>
            <div><%=m.getRowNum()%></div>
            <div><%=m.getOrderNumber()%></div>
            <div><%=m.getMemberName()%></div>
            <div><%=m.getAmountPrice()%></div>
            <div><%=m.getPaymentMethod()%></div>
            <div><%=m.getShippingStatus()%></div>
            <div><%=m.getPaymentDate()%></div>
            <div>
                <span><%=m.getWaybill()%></span>
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

  // 전체선택 체크박스
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

function goSortRef1(start,end,pMethod){
  $.ajax({
    url:'<%=request.getContextPath()%>/manager/sort1',
    data:{
      "searchDate":start,
      "endDate":end,
      "paymentMethod":pMethod,
      // 주문현황
      // 요청사항
    },
    success:data=>{

    },
    error:(e,m,i)=>{
      console.log("sortRef1 error");
      console.log(e);
      console.log(m);
      console.log(i);
    }
  });
};

function goSortRef2(start,end,delivery){
  $.ajax({
    url:'<%=request.getContextPath()%>/manager/sort2',
    data:{
      "searchDate":start,
      "endDate":end,
      "delivery":delivery,
    },
    success:data=>{

    },
    error:(e,m,i)=>{
      console.log("sortRef2 error");
      console.log(e);
      console.log(m);
      console.log(i);
    }
  });
};

function goSortRef3(start,end,con,val){

  $.ajax({
    url:'<%=request.getContextPath()%>/manager/sort3',
    data:{
      "searchDate":start,
      "endDate":end,
      "searchCondition":con,
      "searchVal":val,
    },
    success:data=>{

    },
    error:(e,m,i)=>{
      console.log("sortRef3 error");
      console.log(e);
      console.log(m);
      console.log(i);
    }
  });
};
  // 현황별 조회 값 가져오기
  $(".searchBtn>div>input").click((e)=>{
    // // 정렬기준
    // const sortRef = $("[name=sortMethod]:checked").val();
    // 기준일
    const searchDate = $(".startDate").val();
    // 끝나는 일
    const endDate = $(".endDate").val();

    // 주문현황별 조회
    if($(".sortRef").css("display") ==='grid'){

      // 결제수단
      const paymentMethod = $("[name=paymentMehtod]").val();
      //
      // // 주문현황
      // const orderState= $(".orderStateSelect").val();
      //
      // // 요청사항
      // const request =$(".request>div>input:checked").val();
      goSortRef1(searchDate,endDate,paymentMethod);

    // 배송현황별 조회
    }else if($(".sortRe2f").css("display") ==='grid'){
      const delivery = $(".deliveryState>div>input:checked").val();

      goSortRef2(searchDate,endDate,delivery);

    // 개별 조회
    }else if($(".sortRef3").css("display") ==='grid'){
      const searchCondition = $("[name=searchCondition]:checked").val();
      const searchVal = $(".searchVal").val();

      goSortRef3(searchDate,endDate,searchCondition,searchVal);

    }

  });

// 조회일자 조절
  $(".dateButton>input").click((e)=>{
    function getDateStr(myDate){
      let year = myDate.getFullYear();
      let month = (myDate.getMonth() + 1);
      let day = myDate.getDate();

      month = (month < 10) ? "0" + String(month) : month;
      day = (day < 10) ? "0" + String(day) : day;

      return  (year + '-' + month + '-' + day);
    }

    function today() {
      let d = new Date();
      return getDateStr(d);
    }

    function aWeekAgo() {
      let d = new Date();
      let dayOfMonth = d.getDate();
      d.setDate(dayOfMonth - 7);
      return getDateStr(d);
    }

    function aMonthAgo() {
      let d = new Date();
      let monthOfYear = d.getMonth();
      d.setMonth(monthOfYear - 1);
      return getDateStr(d);
    }

    function twoMonthAgo() {
      let d = new Date();
      let monthOfYear = d.getMonth();
      d.setMonth(monthOfYear - 2);
      return getDateStr(d);
    }

    function fiveMonthAgo() {
      let d = new Date();
      let monthOfYear = d.getMonth();
      d.setMonth(monthOfYear - 5);
      return getDateStr(d);
    }

    let val =$(e.target).val();
    let targetDateTo =today();
    let targetDateFrom ='';

    if( val === '당일'){
      targetDateFrom = today();

    }else if( val ==='1주일' ){
      targetDateFrom = aWeekAgo();

    }else if( val === '당월'){
      targetDateFrom = aMonthAgo();

    }else if( val === '2개월'){
      targetDateFrom = twoMonthAgo();

    }else if( val === '5개월'){
      targetDateFrom = fiveMonthAgo();
    }

    $(".startDate").val(targetDateFrom);
    $(".endDate").val(targetDateTo);
  });


</script>
<%@ include file="/view/common/footer.jsp"%>

