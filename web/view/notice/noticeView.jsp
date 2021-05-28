<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.notice.model.vo.Notice" %>
<%
	Notice n=(Notice)request.getAttribute("notice");
%>
<%@ include file="/view/common/header.jsp"%>
<div id="notice-container">
	<h2>공지사항</h2>
        <table id="tbl-notice">
        <tr class="tr_title">
            <td><%=n.getTitle() %></td>
        </tr>
   		<%if(n.getFilePath()!=null) { %>
        <tr class="tr_file">
            <td>
           			<a href="<%=request.getContextPath()%>/notice/fileDownload?fname=<%=n.getFilePath()%>">첨부파일 : <img src="<%=request.getContextPath()%>/img/icon/icon_file.png" width="30" height="30"><%=n.getFilePath()%></a>
            </td>
        </tr>
   		<%} %>
        <tr class="tr_content">
            <td><%=n.getContent() %></td>
        </tr>
        <%if(loginMember!=null&&loginMember.getUserId().equals("1677958940")){%>
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" onclick="location.assign('<%=request.getContextPath()%>/notice/noticeUpdate?no=<%=n.getNumber()%>')">
                <input type="button" value="삭제하기" onclick="">
            </th>
        </tr>
        <%} %>
    </table>
    </div>

<style>
    section#notice-container{width:900px; height:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:900px; height:600px; margin:0 auto; margin-top:100px; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    #notice-container>h2{
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