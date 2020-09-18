package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.CalorieException;

public class BaseDao {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	//コンストラクタでまずDBに接続
	public BaseDao() throws CalorieException{
		//DBの接続処理
		getConnection();
	}
	//DB接続メソッド
	private void getConnection() throws CalorieException{
		try {
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost/campus?serverTimezone=JST";
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
	protected void close() throws CalorieException {
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
