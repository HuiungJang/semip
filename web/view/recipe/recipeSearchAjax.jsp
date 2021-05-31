<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yoriessence.recipe.model.vo.Recipe, java.util.List" %>
<%
	List<Recipe> recipeList=(List<Recipe>)request.getAttribute("recipeList");
%>
		<div class="grid">
			<%if(recipeList.size()!=0){ 
				for(Recipe r:recipeList) {%>
				<div class="recipe">
					<input name="recipeEnrollNo" type="hidden" value="<%=r.getRecipeEnrollNo()%>">
					<img class="recipe_thumbnail" src="<%=request.getContextPath() %>/<%=r.getRepresentPicture()!=null?"upload/recipe/"+r.getRepresentPicture():"/img/recipe/no_image.png" %>">
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
		</div>
		<div id="pageBar"><%=request.getAttribute("pageBar")!=null?request.getAttribute("pageBar"):"" %></div>
		
	<script>	
			$("div.recipe").click(e=>{
		const recipeEnrollNo=$(e.target).parent().find($("input[name=recipeEnrollNo]")).val();
		console.log(recipeEnrollNo);
		location.assign("<%=request.getContextPath()%>/recipe/recipeView?recipeEnrollNo="+recipeEnrollNo);
	});
	</script>