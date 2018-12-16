<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script type="text/javascript">

//请求json响应json
function requestJson(){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/json/requestJson.action",
		contentType:"application/json;charset=utf-8",
		data:'{"name":"商品名称","price":99}',
		success:function(data){
			console.log(data);
		}
	});
}
function responseJson(){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath }/json/responseJson.action",
		data:{
			"name":"商品名称",
			"price":99
		},
		success:function(data){
			console.log(data);
		}
	});
}
</script>
</head>
<body>
	<h4>请求json，响应json</h4>
	<button onclick="requestJson()">requestJson</button>
	<hr>
	<h4>请求key/value，响应json</h4>
	<button onclick="responseJson()">responseJson</button>
	<hr>
	<a href="${pageContext.request.contextPath }/toLogin.action">登陆页面</a>
	<hr>
	
	<a href="${pageContext.request.contextPath }/rest/items/1">查询商品</a>
	<hr>
	添加商品信息：
	<form action="${pageContext.request.contextPath }/rest/items"
		method="post">
		<input type="text" name="id" value="1" />
		<table width="70%" border=1 cellpadding="0" cellspacing="0">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="添加商品名称" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="999" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value="2018-12-12 10:10:10" /></td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail">商品特级</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
	修改商品信息：
	<form action="${pageContext.request.contextPath }/rest/items"
		method="post">
		<input type="hidden" name="_method" value="PUT" /> <input type="text"
			name="id" value="1" />
		<table width="70%" border=1 cellpadding="0" cellspacing="0">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="修改商品名称" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="999" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value="2018-12-12 10:10:10" /></td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail">商品特级</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
	删除商品：
	<form action="${pageContext.request.contextPath }/rest/items"
		method="post">
		<input type="hidden" name="_method" value="DELETE" /> 
		<input type="text" name="id" value="1" />
		<input type="submit" value="提交" />
	</form>
	
</body>
</html>