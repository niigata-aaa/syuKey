package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * コネクションマネージャ
 */
public class ConnectionManager {

	/**
	 * データベースURL
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/sweets";
	
	/**
	 * ユーザ
	 */
	private static final String USER = "embexU";
	
	/**
	 * パスワード
	 */
	private static final String PASSWORD = "embexP";
	
	/**
	 * データベースへの接続を取得して返します。
	 */
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//JDBCドライバの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
