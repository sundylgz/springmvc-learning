<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="testInterceptor">Test Interceptor</a>
	<br/>

	<form action="upload" method="post" enctype="multipart/form-data"> 
		上传文件:<input type="file" name="uploadFile"/>
		<br/>
		文件描述:<input type="text" name="desc"/>
		<br/>
		<input type="submit" value="上传"/>
	</form>
	<br/>
	<a href="download">点我下载宋老师私密图片</a>
	<br/>
	
	<a href="testJson">Test Json</a>
	<br/>
	
	<a href="emps">List All Emps</a>

</body>
</html>