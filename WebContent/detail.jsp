<%@page import="model.FoodInfomation" %>
<%@page import="java.util.ArrayList" %>
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
		ArrayList<FoodInfomation> foodInfoList =
		(ArrayList<FoodInfomation>)session.getAttribute("list");
		int num = (Integer)request.getAttribute("num");

		%>
				<%=foodInfoList.get(num).getFoodName()%>
				<%=foodInfoList.get(num).getWeight() %>g　は
				<%=foodInfoList.get(num).getCal() %>cal

			<p>
				タンパク質　<%=foodInfoList.get(num).getPro()%>g<br>
				脂質　　　　<%=foodInfoList.get(num).getFat()%>g<br>
				炭水化物　<%=foodInfoList.get(num).getCarbo()%>g<br><br>
			<%
				if(foodInfoList.get(num).getRemarks() != null){
			%>
					備考：<%=foodInfoList.get(num).getRemarks()%>
			<%
				}
			%>
			</p>
	<p><a href="calculation.jsp">戻る</a></p>
</body>
</html>