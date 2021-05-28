<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.recipe.model.vo.Recipe, java.util.List" %>
<%
	List<Recipe> recipeList=(List<Recipe>)request.getAttribute("recipeList");
%>

		<%if(recipeList.size()!=0){ 
			for(Recipe r:recipeList) {%>
				<div class="recipe">
					<input name="recipeEnrollNo" type="hidden" value="<%=r.getRecipeEnrollNo()%>">
					<img src="<%=r.getRepresentPicture()==null?r.getRepresentPicture():request.getContextPath()+"/upload/recipe/no_image.png" %>" height="200px" width="200px">
					<p><%=r.getRecipeTitle() %></p>
					<p><%=r.getMemberId() %></p>
					<span>좋아요 <%=r.getRecommendCount() %></span>
					<span>댓글 <%=r.getCommentCount() %></span>
					<span>조회수 <%=r.getRecipeViewCount() %></span>
				</div>
			<%}
		}else{ %>
			<p>검색 결과가 없습니다.</p>
		<%} %>
	<script>	
			$("div.recipe").click(e=>{
		const recipeEnrollNo=$(e.target).parent().find($("input[name=recipeEnrollNo]")).val();
		console.log(recipeEnrollNo);
		location.assign("<%=request.getContextPath()%>/recipe/recipeView?recipeEnrollNo="+recipeEnrollNo);
	});
	</script>