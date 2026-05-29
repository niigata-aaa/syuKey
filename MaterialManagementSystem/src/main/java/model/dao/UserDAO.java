package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.UserBean;

public class UserDAO {
	/**
	 * 全てのユーザーリストを返します。
	 */
	public List<UserBean>selectAll() throws SQLException,ClassNotFoundException{
		List<UserBean> userList = new ArrayList<UserBean>();
		//データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * From m_user")){
			//結果の操作
			while(res.next()){
				String user_id = res.getString("user_id");
				String user_pass = res.getString("user_pass");
				Boolean admin_flg = res.getBoolean("admin_flg");
				Date last_login_date = res.getDate("last_login_date");

				UserBean user = new UserBean();
				user.setUser_id(user_id);
				user.setUser_pass(user_pass);
				user.setAdmin_flg(admin_flg);
				user.setLast_login_date(last_login_date);
			}
		}
		return userList;
	}

	/**
	 * ユーザ登録
	 */
	public int insert(UserBean user) throws ClassNotFoundException,SQLException{
		int processingNumber = 0; //処理件数
		
		String sql = "INSERT INTO m_user(user_id, user_pass, admin_flg) VALUES(?,?,?)";

		//データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//DTOからデータの取り出し
			String user_id = user.getUser_id();
			String user_pass = user.getUser_pass();
			Boolean admin_flg = user.getAdmin_flg();

			//プレースホルダーへの値の設定
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pass);
			pstmt.setBoolean(2, admin_flg);

			//SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	/**
	 * ユーザ更新
	 */
	public int update(UserBean user) throws ClassNotFoundException,SQLException{
		int processingNumber = 0; //処理件数
		
		String sql = "UPDATE m_user SET user_pass = ? WHERE user_id = ?";
		
		//データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){

		//DTOからデータの取り出し
		String user_id = user.getUser_id();
		String user_pass = user.getUser_pass();
		
		//プレースホルダーへの値の設定
		pstmt.setString(2, user_id);
		pstmt.setString(1, user_pass);
		
		//SQLステートメントの実行
		processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	/**
	 * ユーザ削除
	 */
	public int delete(UserBean user) throws ClassNotFoundException,SQLException {
		int count = 0; //処理件数

		String sql = "DELETE FROM m_user WHERE user_id = ?";

		//データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//DTOからデータの取り出し
			String user_id = user.getUser_id();
			
			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;
	}
}
