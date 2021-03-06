<%@page import="model.FoodInfomation" %>
<%@page import="model.TotalCal" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link rel="stylesheet" href="style.css" type="text/css">--%>
<title>カロリー計算 M.M</title>
</head>
<body>
	<h1<%--　class="set2"--%>><span>カロリー計算 F.M</span></h1>
	<h2>食材名、重量(g)を入力してください</h2>
	<%
		//list(食材の情報)を取得
		ArrayList<FoodInfomation> foodInfoList =
			(ArrayList<FoodInfomation>)session.getAttribute("list");
		//totalCalを取得
		TotalCal totalCal =
				(TotalCal)session.getAttribute("totalCal");
		//messageを取得
		String message = (String)request.getAttribute("message");

		if(foodInfoList != null){
	%>
	<table>
	<%
			for(int i = 0;i < foodInfoList.size();i++){
	%>
			<tr>
				<%--番号を表示 --%>
				<td><%=(i+1) %></td>
				<%--detail.jspへのリンク付き食材名
					現在の繰り返し回数の番号をdetail.jspへ値渡しする
				 --%>
				<td><a href="DetailServlet?num=<%=(i)%>"><%=foodInfoList.get(i).getFoodName() %></a></td>
				<%--重量(g)を表示 --%>
				<td><%=foodInfoList.get(i).getWeight() %>g　は</td>
				<%--食材のカロリーを表示 --%>
				<td><%=foodInfoList.get(i).getCal() %>kcal</td>
			</tr>
		<%
			}
		%>
	</table>
	<p><%--累計した合計カロリーを表示 --%>
		合計<%=totalCal.getTotalCal()%>kcal
	</p>
	<%
		}
		//例外が発生した時messageを表示する
		if(message != null){
	%>
			<p><%=message %></p>

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