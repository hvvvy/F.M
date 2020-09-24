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
			for(int i = 0;i < foodInfoList.size();i++){
		%>
				<%=foodInfoList.get(i).getFoodName()%>
				<%=foodInfoList.get(i).getWeight() %>g　は
				<%=foodInfoList.get(i).getCal() %>cal

			<p>
				タンパク質　<%=foodInfoList.get(i).getPro()%>g<br>
				脂質　　　　<%=foodInfoList.get(i).getFat()%>g<br>
				炭水化物　<%=foodInfoList.get(i).getCarbo()%>g<br><br>
			<%
				if(foodInfoList.get(i).getRemarks() != null){
			%>
					備考：<%=foodInfoList.get(i).getRemarks()%>
			<%
				}
			%>
			</p>
		<%
			}
		%>
	<p><a href="calculation.jsp">戻る</a></p>
</body>
</html>