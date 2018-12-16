<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
<%-- ${username }
<a href="${pageContext.request.contextPath }/logout.action">退出</a> --%>
	<form name="itemsForm"
		action="${pageContext.request.contextPath }/items/queryItems.action"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>商品名称：<input name="itemsCustom.name" type="text" /><br>
					商品描述：<input name="itemsCustom.detail" type="text" /><br>
					创建时间：<input name="createtime" type="text" /><br>
					<input type="checkbox" name="items_id" value="1"/>
					<input type="checkbox" name="items_id" value="2"/>
					<input type="checkbox" name="items_id" value="3"/>

					商品List0：<input name="itemss[0].name" type="text" /><br>
					商品List1：<input name="itemss[1].name" type="text" /><br> 
					商品Map0：<input name="map['name']" type="text" /><br>
					商品Map1：<input name="map['price']" type="text" /><br>
				</td>
				<td><input type="submit" value="查询" /> <input type="button"
					value="查询" onclick="queryItems()" /> <input type="button"
					value="批量删除" onclick="deleteItems()" /> <input type="button"
					value="JsonToJson" onclick="requestJson()" /> <input type="button"
					value="KvToJson" onclick="responseJson()" /></td>
			</tr>
		</table>
	</form>

	商品列表：
<table width="100%" border=1 cellpadding="0" cellspacing="0">
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item">
<tr>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	<td><a href="${pageContext.request.contextPath }/items/queryItemsById.action?id=${item.id}">修改</a> </td>
</tr>
</c:forEach>
</table>
</body>

</html>