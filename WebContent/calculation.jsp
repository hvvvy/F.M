<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カロリー計算 M.M</title>
</head>
<body>
	<h1>カロリー計算 M.M</h1>
	<h2>食材名、重量(g)を入力してください</h2>
	<form action="CalculationServvlet" method="post">
		<input type="text" name="foodName" placeholder="食材名"/>
		<input type="text" name="weight" placeholder="重量(g)"/><br>
		<input type="submit" value="実行"/>
	</form>
	<form action="CalculationServlet">
		<input type="submit" value="クリア">
	</form>
</body>
</html>