<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.yoriessence.recipe.model.vo.RecipeComment" %>
<%
	List<RecipeComment> comments=(List<RecipeComment>)request.getAttribute("comments");
%>

<%if(comments.size()!=0){ 
	for(RecipeComment c:comments){%>
		<div class="comment_row">
		    <img src="">
		    <div class="comment_info">
		    	<a class="comment_writer"><%=c.getRecipeCommentWriter() %></a>
		    	<p class="comment_date"><%=c.getCommentEnrollDate() %></p>
		    	<p class="comment_content"><%=c.getRecipeComment() %></p>
		    </div>
		</div>
	<%}
}else{%>
	<div class="no_comment">작성된 댓글이 없습니다.</div>
<%} %>

<script>
	$(function(){

		$("#comment_title").html("댓글 <%=comments.size()%> 개");
	})
</script>

