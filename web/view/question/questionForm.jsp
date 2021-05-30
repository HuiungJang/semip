<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/common/header.jsp"%>
	<div id="question-container">
  <h1>1:1 문의 등록</h1>
    <form action="<%=request.getContextPath()%>/question/questionWriteEnd" method="post" enctype="multipart/form-data">
        <table id="tbl-question">
        <tr Style="height:50px;">
            <th>제 목</th>
            <td><input type="text" name="questionTitle" id="questionTitle" required></td>
        </tr>
         <tr Style="height:50px;">
            <th>작성자</th>
            <td><input type="text" name="questionWrite" id="questionWrite" value="<%=loginMember.getUserId()%>" readonly></td>
            
        </tr>
        <tr Style="height:50px;">
            <th>첨부파일</th>
            <td><input type="file" name="up_file"></td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea rows="5" cols="50" name="content" style="border:none; margin:0 auto;width:100%; height:100%;"></textarea></td>
        </tr>
        <tr Style="height:50px;">
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="">
            </th>
        </tr>
    </table>
    </form>
    </div>

    <style>
    div#question-container{width:1000px; margin:0 auto; text-align:center;}
    div#question-container h1{margin:10px 0; }
    table#tbl-question{width:1000px; height:600px; margin:0 auto; margin-top:100px; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-question th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-question td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    #questionTitle{
    	width:830px;
    	border: none;
    	height: 40px;
    }
    #questionWrite{
    	width:830px;
    	border: none;
    	height: 40px;
    }
    </style>	
<%@ include file="/view/common/footer.jsp"%>