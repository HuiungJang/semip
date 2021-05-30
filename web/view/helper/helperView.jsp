<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.helper.model.vo.Helper" %>
<%
	Helper h=(Helper)request.getAttribute("helper");
%>
<%@ include file="/view/common/header.jsp"%>
<div id="helper-container">
	<h2>공지사항</h2>
        <table id="tbl-helper">
        <tr class="tr_title">
            <td><%=h.getTitle() %></td>
        </tr>
        <tr class="tr_content">
            <td><%=h.getContent() %></td>
        </tr>
        <%if(loginMember!=null&&loginMember.getUserId().equals("1677958940")){%>
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" onclick="location.assign('<%=request.getContextPath()%>/helper/helperUpdate?no=<%=h.getNumber()%>')">
                <input type="button" value="삭제하기" onclick="location.assign('<%=request.getContextPath()%>/helper/helperDelete?no=<%=h.getNumber()%>')">
            </th>
        </tr>
        <%} %>
    </table>
    </div>

<style>
    section#helper-container{width:900px; height:600px; margin:0 auto; text-align:center;}
    section#helper-container h2{margin:10px 0;}
    table#tbl-helper{width:900px; height:600px; margin:0 auto; margin-top:100px; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-helper th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-helper td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    #helper-container>h2{
	    text-align: center;
	    font-size: 35px;
	    margin-top:50px;
	}
	.tr_title>td{
		height:70px;
		text-align:center;
	}
	.tr_file{
		height:50px;
	}
</style>	


<%@ include file="/view/common/footer.jsp"%>