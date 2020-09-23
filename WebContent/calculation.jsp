<%@page import="model.FoodInfomation" %>
<%@page import="java.util.ArrayList" %>
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
	<%
		ArrayList<FoodInfomation> foodInfoList =
			(ArrayList<FoodInfomation>)session.getAttribute("list");
		if(foodInfoList != null){
		for(int i = 0;i < foodInfoList.size();i++){
			request.setAttribute("foodName", (foodInfoList.get(i).getFoodName()));
			request.setAttribute("weight", (foodInfoList.get(i).getWeight()));
			request.setAttribute("cal", (foodInfoList.get(i).getCal()));
		}
	%>
	<table>
	<%
			for(int i = 0;i < foodInfoList.size();i++){
	%>
			<tr>
				<td><%=(i+1) %></td>
				<td><a href="detail.jsp"><%=foodInfoList.get(i).getFoodName() %></a></td>
				<td><%=foodInfoList.get(i).getWeight() %>g　は</td>
				<td><%=foodInfoList.get(i).getCal() %>cal</td>
			</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>


	<form action="CalculationServlet" method="post">
		<input type="text" name="foodName" placeholder="食材名"/>
		<input type="text" name="weight" placeholder="重量(g)"/><br>
		<input type="submit" value="実行"/>
	</form>
	<form action="CalculationServlet">
		<input type="submit" value="クリア">
	</form>
</body>
</html>