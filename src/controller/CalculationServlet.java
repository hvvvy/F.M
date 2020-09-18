package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodInfomationDao;
import model.FoodInfomation;


@WebServlet("/CalculationServlet")
public class CalculationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String foodName = request.getParameter("foodName");
		int weight = Integer.parseInt(request.getParameter("weight"));

		//入力された食材名を基にDBにログイン処理
		//なければ例外（CalorieException)を発生させる
		FoodInfomationDao foodInfoDao = new FoodInfomationDao();
		FoodInfomation foodInfo = foodInfoDao.doSearch(foodName);

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
