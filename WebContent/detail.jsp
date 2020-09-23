<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
</head>
<body>
		<%
		String foodName = (String)request.getAttribute("foodName");
		String weight = (String)request.getAttribute("weight");
		String cal = (String)request.getAttribute("cal");
		%>
	<p>
		<%=foodName %>　<%=weight %>g　は　<%=cal %>cal
	</p>

	<p>
		タンパク質　g<br>
		脂質　　　　g<br>
		炭水化物　g<br><br>
		備考：
	</p>
	<p><a href="calculation.jsp">戻る</a></p>
</body>
</html>