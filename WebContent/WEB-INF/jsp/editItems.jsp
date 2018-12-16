<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body>
<!-- 显示全部错误信息 -->
<c:if test="${allErrors!=null }">
	<c:forEach items="${allErrors }" var="error">
		${error.defaultMessage }<br>
	</c:forEach>
</c:if>
	<form action="${pageContext.request.contextPath }/items/saveItems.action"
		method="post" >
		<input type="hidden" name="_method" value="PUT" />
		<input type="hidden" name="id" value="${itemsCustom.id }" /> 修改商品信息：
		<table width="70%" border=1 cellpadding="0" cellspacing="0">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${itemsCustom.name }" /></td>
				<td width="300"><c:if test="${NotEmpty!=null }">${NotEmpty }</c:if></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${itemsCustom.price }" /></td>
				<td><c:if test="${Min!=null }">${Min }</c:if></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
				<td><c:if test="${Past!=null }">${Past }</c:if></td>
			</tr>
			<%-- <tr>
				<td>商品图片</td>
				<td><c:if test="${itemsCustom.pic !=null}">
						<img src="/pic/${itemsCustom.pic}" width=100 height=100 />
						<br />
					</c:if> <input type="file" name="items_pic" /></td>
			</tr> --%>
			<tr>
				<td>商品简介</td>
				<td>
					<textarea rows="3" cols="30" 
						name="detail">${itemsCustom.detail }</textarea>
				</td>
				<td><c:if test="${NotBlank!=null }">${NotBlank }</c:if></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>