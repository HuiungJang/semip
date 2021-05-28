<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/common/header.jsp"%>
<style>
	.test{
		float: left;
	}
	.text{
		font-size:38px;
		margin-left:30px
	}
	.allpark{
		margin-top:390px;
		margin-left:30px;
        font-size:38px;
	}
	.jsp{
		text-align:center;
		font-size:30px;
	}
	.shop{
		height:200px;
		width:200px;
		margin:40px;
	}
	.meaning{
        margin-top:20px;
		margin-left:30px
        font-size:38px;
	}
	.top{
		border-top:8px black solid;
		width:1800px;
	}
	#tr2{
	width:1500px;
	border-bottom:8px black solid;
	}
	#tr{
		border-top:8px black solid;
		border-bottom:8px black solid;
      	height:38px;
        width:1800px;
        margin-top:50px;
       	margin-left:30px;
        text-align:center;
       }
     a{
	    font-family: 'Dosis', sans-serif;
	    font-size:38px;
	    color: black;
	}
	.search{
		height:50px;
        width:440px;
        position: absolute;
        top:20%;
        left:32%;
        font-size:38px;
	}
	.search2{
		height:50px;
        width:100px;
        position: absolute;
        top:20%;
        left:56%;
        text-align:center;
        font-size:38px;
        background-color:#8CC7BC;
	}
	
	#pageBar>*{
		
		margin-left:20px;
	}
	.underlines{
    background:
		linear-gradient(#1F695B 0 0)
        bottom /var(--d, 0) 3px
        no-repeat;
		transition:0.5s;
		font-size:38px;
		   
	}
	.underlines:hover{
	    --d: 100%;
	}
</style>
<div>
	<form action="<%=request.getContextPath() %>/shopping/search">
		<input type="text" name="search" class="search" size="38" placeholder="검색할 상품을 입력하세요">
		<button type="submit" class="search2">검색</button>
	</form>
	<table id="tr">
		<tr>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="일식">
				<input type="submit" class="underlines" value="일식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="중식">
				<input type="submit" class="underlines" value="중식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="양식">
				<input type="submit" class="underlines" value="양식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="한식">
				<input type="submit" class="underlines" value="한식">
			</td>
			</form>
			<form action="<%=request.getContextPath() %>/ShoppingKategorie">
			<td>
				<input type="hidden" name="kategori" value="과자">
				<input type="submit" class="underlines" value="과자">
			</td>
			</form>
		</tr>
	</table>
</div>














































