<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
마이페이지
<h2>환영합니다. ${customer.name}님</h2>
<h4>아이디 : ${customer.id}</h4><br />
<h4>비번 : ${customer.pw}</h4><br />
<h4>이름 : ${customer.name}</h4><br />
<h4>주민번호 : ${customer.ssn} </h4><br />
<h4>신용도 : ${customer.credit} </h4><br />
</body>
</html>