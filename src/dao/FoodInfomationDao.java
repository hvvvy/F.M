package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.CalorieException;
import model.Calculation;
import model.TotalCal;

public class FoodInfomationDao {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	//コンストラクタでまずDBに接続
	public FoodInfomationDao() throws CalorieException{
		//DBの接続処理
		getConnection();
	}

	public Calculation doSearch(String foodName,int weight,TotalCal totalCal)
		throws CalorieException{
			//食材情報
			Calculation calculation = null;
			try {
				//検索実行
				String sql = "SELECT * FROM food_infomation WHERE food_name = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, foodName);
				rs = ps.executeQuery();
				while(rs.next()) {

					String pro = rs.getString("protein");
					String fat = rs.getString("fat");
					String carbo = rs.getString("carbohydrate");
					String remarks = rs.getString("remarks");
					calculation = new Calculation(foodName,weight,pro,fat,carbo,remarks,totalCal);
				}

				//結果を確認
				if(calculation == null) {
					throw new CalorieException("取得できませんでした");
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new CalorieException("SQL実行中に例外が発生しました");
			}finally {
				//DBの接続解除処理
				try {
				close();
				}catch(CalorieException e){
					e.printStackTrace();
				}
			}
		//食材の情報を返却
		return calculation;
	}

	//DB接続メソッド
	private void getConnection() throws CalorieException{
		try {
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost/foodinfomation?serverTimezone=JST";
				String user = "root";
				String password = "root";
				//DB接続
				con = DriverManager.getConnection(url,user,password);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new CalorieException("JDBCドライバが見つかりません");
		}catch(SQLException e) {
			e.printStackTrace();
			throw new CalorieException("SQL実行中に例外が発生しました");
		}
	}

	//DB接続解除メソッド
	private void close() throws CalorieException {
		try {
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException e) {
			throw new CalorieException("close処理中に例外が発生しました");
		}
	}
}
