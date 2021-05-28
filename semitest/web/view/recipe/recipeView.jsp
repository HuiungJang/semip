<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/common/header.jsp"%>
<%@ page import="java.util.List, java.util.Map, com.yoriessence.recipe.model.vo.Recipe, com.yoriessence.recipe.model.vo.RecipeIngredient, com.yoriessence.recipe.model.vo.RecipeComment, com.yoriessence.recipe.model.vo.RecipePicture" %>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<%
	Recipe recipe=(Recipe)request.getAttribute("recipeView");
	List<String> ingCategory=(List<String>)request.getAttribute("category");
	Map<String, List<RecipeIngredient>> ingredient=(Map<String, List<RecipeIngredient>>)request.getAttribute("ingredient");
	List<RecipeComment> comments=(List<RecipeComment>)request.getAttribute("comments");
	List<RecipePicture> pictures=(List<RecipePicture>)request.getAttribute("pictures");
%>
<style>
                
    section{
        width:1100px;
        margin:20px auto;
        padding :20px;
        overflow:hidden;
    }
    
    #chef_Profile{
        width:900px;
        display:flex;
        align-items:center;
        margin:0 auto;
        margin-top:30px;
        padding-bottom:20px;
        border-bottom:1px solid black;
        padding-top: 20px;
        border-top:1px solid black;
    
        justify-content:space-between;
    }
    .chefContainer{
        display:inline-flex;
    }
    .chefContainer .like{
        width: 30px;
        height: 30px;
    }
    #picContainer{
        margin-left: 30px;
    }
    #picContainer>img{
        border-radius: 200px;
    }
    
    #chefTitle{
        font-weight: bold;
        font-size:28px;
    }
    #chef_content .text{
        font-size: 20px;
    }
    #sendDM{
        margin-left: 65px;
        margin-top: 5px;
    }
    #chef_content{
        margin-left: 50px;
    }
    


	/* 레시피 정보 출력부분 */
	
    #chef_recipe{
        width:900px;
        margin:0 auto;
        position:relative;
    }
    
    .recipe_container{
        margin:0 auto;
        width:900px;
    }
    
    .recipe_container>div{
        margin:0 auto;
        padding:50px 10px;
     	border-bottom:1px solid black;
	}
	
    #recipe_info{
        text-align:center;
    }
    
    .recipe_thumbnail{
    	margin-bottom:20px;
    }
    
    #recipe_title{
    	display:block;
    	font-size:50px;
    	font-weight:bold;
    	margin-bottom:20px;
    }
    
    #recipe_intro{
    	color:grey;
    	font-weight:bold;
    	font-size:30px;
    }
    
    .info_align{
    	display:flex; justify-content:space-between; padding:0 30px;
    }
                
	/* 레시피 메뉴 */
	.menu{
		position:absolute;
		top:50px;
		right:50px;
	}
	.recipe_menubar{
		display:none;
		border:#DCDCDC solid 1px;
		padding:10px;
		width:60px;
	}
	.recipe_menubar>*{
		display:block;
	}
	.recipe_menubar>button{
		border:none;
		background-color:white;
	}
	
                
	/* 레시피 재료 */
	.info_title{
		font-size:20px;
		font-weight:bold;
		color:red;
	}
	
	.ingredient_container>*{
		display:inline-block;
		margin-top:20px;
		vertical-align:top;
	}
	.ingredient_category{
		width:100px;
	}
	
	.ingredient_li{
		display:flex;
	}
	
	.ingredient_name{
		width:80px;
	}
	.ingredient_amount{
		color:grey;
	}
	
	/* 레시피 과정 */
	.step{
		display:flex;
		margin:20px 0;
	}
	.step:last-child{
		margin-bottom:0;
	}
	.step_title{
		width:100px;
	}
	.step_content{
		width:680px;
	}
	.step_img{
		width:100px; height:100px;
		float:right;
	}
	

	/* 레시피 댓글 */
    .comment_container{
        margin:0 auto;
        padding:50px 10px;
     	border-bottom:1px solid black;
     	overflow:hidden;
	}
	
    #comment_title{
		margin-bottom:20px;
    }
    
    .profile_img{
    	width:50px; height:50px; float:left;
    	margin-right:10px;
    }
    
	/* 댓글 작성창 */
    #write_comment{
    	margin-bottom:20px;
    }
	
    #recipe_comment{
    	width:750px; height:50px;
    	resize:none;
    }
	
	#comment_submit{
		width:60px; height:50px; vertical-align:top;
	}
	
	/* 댓글창 */
	.comment_row{
		margin-bottom:20px;
     	overflow:hidden;
	}
	
    .comment_info{
    	display:flex;
    }
    

    
</style>

    <section>
        <div id="chef_Profile">
            <div class="chefContainer">
                <span id="picContainer">
                    <img src="data:image/jpeg;base64,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" height="200px" width="200px">
                    <br><input type="button" id="sendDM" value="DM 보내기">
                </span>
                <input type="button" value="추천" class="like">
                <span id="chef_content">
                    <img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/18/32775e06923a4bef0cb6093ff84d28ef1.jpg" width="50px" height="50px">
                    <span id="chefTitle">000 셰프의 레시피 에센스</span>
                    <br><br><br>
                    <span class="text">
                        <p><a>이름</a></p>
                        <p><a>이름</a></p>
                        <br>
                        <span><a> SNS주소 </a></span> <span><a> SNS주소 </a></span> <span><a> SNS주소 </a></span>
                    </span>
                </span>
            </div>
        </div>
        <div id="chef_recipe">
        	<form action="<%=request.getContextPath()%>/recipe/recipeUpdate" method="post">
	        	<div class="menu">
		      		<a id="btn_menu">메뉴</a>
		      		<div class="recipe_menubar">
		      			<input type="hidden" name="recipeEnrollNo" value="<%=recipe.getRecipeEnrollNo()%>"/>
		      			<button type="submit" id="recipeUpdate">수정</button>
		      			<button id="recipeDelete">삭제</button>
		      		</div>
		      	</div>
	      	</form>
            <div class="recipe_container">
                <div id="recipe_info">
                	<%if(recipe.getRepresentPicture()!=null){ %>
                    	<img class="recipe_thumbnail" src="<%=request.getContextPath() %>/upload/recipe/<%=recipe.getRepresentPicture() %>" width="500px" height="281px">
                   	<%} %>
                    <p id="recipe_title"><%=recipe.getRecipeTitle() %></p>
                    <%if(recipe.getRecipeIntro()!=null){%>
                    	<p id="recipe_intro"></p>
                    <%} %>
                    <%if(recipe.getRecipeVideoAddress()!=null) {%>
                    	<p><%=recipe.getRecipeVideoAddress() %></p>
                    <%} %>
                    <div class="info_align"><span>좋아요 <%=recipe.getRecommendCount() %></span><span>댓글 <%=comments.size() %></span><span>조회수 <%=recipe.getRecipeViewCount() %></span></div>
                </div>
                <div id="recipe_ingredient">
                    <p class="info_title">재료</p>
                   	<div>
	                    <%for(String c:ingCategory){ %>
	                    	<div class="ingredient_container">
		                    	<p class="ingredient_category"><%=c%></p>
		                    	<%List<RecipeIngredient> riList=ingredient.get(c);%>
		                    	<ul class="ingredient_ul">
			                    	<%for(RecipeIngredient ri:riList){%>
			                			<li class="ingredient_li">
			                				<p class="ingredient_name"><%=ri.getIngredientName() %></p>
			                				<p class="ingredient_amount"><%=ri.getIngredientAmount() %></p>
		                				</li>
			                  		<%}%>
		                  		</ul>
	                    	</div>
	                    <%} %>
                    </div>
                </div>
                <div id="recipe_procedure">
                    <p class="info_title">만드는 방법</p>
                    <div>
	                    <ul>
	                    	<% String[] procedure=recipe.getRecipeProcedure().split("Step.");
	                    	for(int i=0;i<procedure.length;i++) {%>
	                        <li class="step">
	                        	<p class="step_title">
	                        	<p class="step_content"><%=procedure[i]%></p>
 	                        	<%if(pictures.get(i)!=null && pictures.get(i).getRecipeEnrollPicture()!=null) { %>
	                        		<img src="<%=request.getContextPath() %>/upload/recipe/<%=pictures.get(i).getRecipeEnrollPicture()%>" class="step_img"></li>
	                        	<%}%>
	                       	<% } %>
	                    </ul>
                    </div>
                </div>
            </div>
            <div class="comment_container">
            	<p class="info_title" id="comment_title">댓글 </p>
                <div id="write_comment">
                    <img class="profile_img" src="">
                    <input type="hidden" name="recipe_enroll_no" id="recipe_enroll_no" value="<%=recipe.getRecipeEnrollNo()%>">
                    <input type="hidden" name="recipe_comment_writer" id="recipe_comment_writer" value="testId2"> <%-- <%=loginMember.getUserId()%> --%>
                    <textarea name="recipe_comment" id="recipe_comment" rows="2" cols="150"></textarea>
                    <input type="submit" name="comment_submit" id="comment_submit" value="등록">
                </div>
                <div id="view_comment">
	                <%if(comments.size()!=0){ 
	                	for(RecipeComment c:comments){%>
		                <div class="comment_row">
		                    <img class="profile_img" src="">
		                    <div class="comment_info">
		                    	<a class="comment_writer"><%=c.getRecipeCommentWriter() %></a>
		                    	<p class="comment_date"><%=c.getCommentEnrollDate() %></p>
	                    	</div>
	                    	<p class="comment_content"><%=c.getRecipeComment() %></p>
		                </div>
	                	<%}
	                }else{%>
	                	<div class="no_comment">작성된 댓글이 없습니다.</div>
	                <%} %>
                </div>
            </div>
        </div>
    </section>
    
    <script>
    	$(function(){
    		//댓글 등록하는 기능
     		$("#comment_submit").click(e=>{
     			//아무것도 입력하지 않으면 등록 안되도록 처리
     			if($("#recipe_comment").val()==""){
     				alert("내용을 입력하세요.");
     			}else{
					$.ajax({
						url:"<%=request.getContextPath()%>/recipe/insertComment",
						data:{
							recipeEnrollNo:<%=recipe.getRecipeEnrollNo()%>,
							recipeComment:$("#recipe_comment").val(),
							recipeCommentWriter:$("#recipe_comment_writer").val()
						},
						success:data=>{
							$("#view_comment").html(data);
						}
					});
     			}
    		});
    		
    		$("#btn_menu").click(e=>{
    			const menu=$(e.target).next();
    			if(menu.css("display")=="block"){
    				menu.css("display","none");
    			}else{
    				menu.css("display","block");
    			}
    		});
    		
    		
    		$(".step_title").each((i,v)=>{
    			$(v).html("Step "+(i+1));
    		});
    		

    		$("#comment_title").html("댓글 <%=comments.size()%> 개");
    		
    		
    		
    		
    	});
    </script>
    
<%@ include file="/view/common/footer.jsp"%>