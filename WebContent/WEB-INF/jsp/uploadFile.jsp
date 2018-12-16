<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/upload/uploadFile.action" 
	method="post" enctype="multipart/form-data">
	<input type="file" multiple name="uploadFile">
	
	<input type="submit" value="submit">	
</form>
</body>
</html>