package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodInfomationDao;
import exception.CalorieException;
import model.Calculation;
import model.FoodInfomation;
import model.FoodInfomationManager;
import model.TotalCal;


@WebServlet("/CalculationServlet")
public class CalculationServlet extends HttpServlet {

			//合計カロリーを保持するクラス
			TotalCal totalCal = new TotalCal();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String message;
		try {
			request.setCharacterEncoding("UTF-8");
			String foodName = request.getParameter("foodName");
			//重量が正しく入力されなければ例外(NumberFormatException)を発生させる
			int weight = Integer.parseInt(request.getParameter("weight"));



			//入力された食材名を基にDBにログイン処理
			//なければ例外（CalorieException)を発生させる
			FoodInfomationDao foodInfoDao = new FoodInfomationDao();
			//取得した情報を基にCaluclationクラスで計算
			Calculation calculation = foodInfoDao.doSearch(foodName,weight,totalCal);
			//計算された情報をmodelクラスに格納
			//このfoodInfoはdetail.jsp(詳細画面)で使用
			FoodInfomation foodInfo = calculation.getResult();

			//セッションを取得
			HttpSession session = request.getSession();
			//セッションから取得した食材の情報を取得
			ArrayList<FoodInfomation> foodInfoList =
					(ArrayList<FoodInfomation>)session.getAttribute("list");


			//モデルに一覧追加処理を指示
			FoodInfomationManager foodInfoManager = new FoodInfomationManager();
			foodInfoList = foodInfoManager.getFoodInfoList(
					foodInfoList,
					foodInfo.getFoodName(),
					foodInfo.getWeight(),
					foodInfo.getCal(),
					foodInfo.getPro(),
					foodInfo.getFat(),
					foodInfo.getCarbo(),
					foodInfo.getRemarks()
					);

			//セッションに設定
			session.setAttribute("list", foodInfoList);
			//セッションにTotalCalを設定
			session.setAttribute("totalCal", totalCal);

		} catch (CalorieException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			message = "食材名または重量(g)が正しく入力されていません。";
			request.setAttribute("message",message);
		}

		//セッションの情報を表示させるためにもう一度計算画面を表示
		RequestDispatcher rd = request.getRequestDispatcher("calculation.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		session.invalidate();
		//合計カロリーの値をクリア
		totalCal.setTotalCal(0);/**もう1つの案としてクラスを新しく作成する→クリアするたびにオブジェクトを作成するので非効率的
								new TotalCal();**/

		//セッションの情報をクリアしてもう一度計算画面を表示
		RequestDispatcher rd =
				request.getRequestDispatcher("calculation.jsp");
		rd.forward(request, response);
	}
}
