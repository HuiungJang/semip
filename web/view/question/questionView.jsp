<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.question.model.vo.Question, java.util.List, com.yoriessence.question.model.vo.QuestionComment" %>
<%
	Question q=(Question)request.getAttribute("question");
	QuestionComment qc=(QuestionComment)request.getAttribute("questionComment");
	List<QuestionComment> comments=(List<QuestionComment>)request.getAttribute("comments");
%>
<%@ include file="/view/common/header.jsp"%>
<div id="question-container">
	<h2>1:1 문의</h2>
        <table id="tbl-question">
        <tr class="tr_title">
            <th><%=q.getQuestionTitle()%></th>
        </tr>
   		<%if(q.getQuestionPic()!=null) { %>
        <tr class="tr_file">
            <td>
           		<a href="<%=request.getContextPath()%>/question/fileDownload?fname=<%=q.getQuestionPic()%>">첨부파일 : <img src="<%=request.getContextPath()%>/img/icon/icon_file.png" width="30" height="30"><%=q.getQuestionPic()%></a>
            </td>
        </tr>
        <tr class="tr_writer">
        	<td>작성자 : <%=q.getMemberId() %></td>
        </tr>
   		<%} %>
        <tr class="tr_content">
            <td><%=q.getQuestionContent()%></td>
        </tr>
        <%if(qc==null) { %>
        <tr style="height:50px">
            <th colspan="2">
                <input type="button" value="수정하기" onclick="location.assign('<%=request.getContextPath()%>/question/questionUpdate?no=<%=q.getQuestionNumber()%>')">
                <input type="button" value="삭제하기" onclick="location.assign('<%=request.getContextPath()%>/question/questionDelete?no=<%=q.getQuestionNumber()%>')">
            </th>
        </tr>
        <%}else if(qc!=null){ %>
	        <tr class="tr_title">
	        	<th>[문의답변]-><%=q.getQuestionTitle() %></th>
	        </tr>
	        <tr>
	        	<td><%=qc.getCommentContent() %></td>
	        </tr>
	    <%} %>
        <%if(loginMember!=null&&loginMember.getUserId().equals("1677958940")){%> <!-- admin으로 수정할것 -->
	        <%if(qc==null){ %>
	        <tr class="comment-form">
	        	<th>
			       	<form action="<%=request.getContextPath()%>/question/insertQuestionComment" method="post" style="text-align:center;">
				        	<textarea name="commentContent" cols="55" rows="3"></textarea>
				        	<input type="hidden" id="commentNumber" name="commentNumber" value="<%=q.getQuestionNumber()%>">
				        	<input type="hidden" id="CommentMemberId" name="CommentMemberId" value="<%=loginMember.getUserId()%>">
				        	<button type="submit" id="btn-comment" style="width:50px; height:30px;">등록</button>
			       	</form>
	        	</th>
	        </tr>
	        <%} 
	        }%>
    </table>
    </div>

<style>
    section#question-container{width:900px; height:800px; margin:0 auto; text-align:center;}
    section#nquestion-container h2{margin:10px 0;}
    table#tbl-question{width:900px; height:800px; margin:0 auto; margin-top:100px; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-question th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-question td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    #question-container>h2{
	    text-align: center;
	    font-size: 35px;
	    margin-top:50px;
	}
	.tr_title>th{
		height:50px;
		text-align:center;
	}
	.tr_file{
		height:50px;
	}
	.tr_writer>td{
		height:50px;
		text-align:center;
	}
	.comment-form{
		height:200px;
	}
	.comment-form textarea{
		width:800px;
		height:200px;
		border:none;
	}
</style>	


<%@ include file="/view/common/footer.jsp"%>