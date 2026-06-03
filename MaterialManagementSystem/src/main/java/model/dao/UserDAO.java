package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.MaterialBean;
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
				
				userList.add(user);
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
			pstmt.setBoolean(3, admin_flg);

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
			pstmt.setString(1, user_pass);
			pstmt.setString(2, user_id);


			//SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	/**
	 * ユーザ削除
	 */
	public int delete(UserBean user) throws ClassNotFoundException,SQLException {
		int processingNumber = 0; //処理件数
		String sql = "DELETE FROM m_material WHERE user_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//DTOからデータの取り出し
			String user_id = user.getUser_id();

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		
		
		sql = "DELETE FROM m_user WHERE user_id = ?";

		//データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//DTOからデータの取り出し
			String user_id = user.getUser_id();

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}

		return processingNumber;


	}

	/**
	 *管理者の材料マスタ削除
	 */
	public int MaterialDelete(MaterialBean material) throws SQLException, ClassNotFoundException {
		int cnt = 0;
		String sql = "delete from m_material where material_name = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			String material_name = material.getMaterial_name();

			pstmt.setString(1, material_name);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * ログインチェック
	 */
	public boolean loginCheck(String user_id, String user_pass) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND user_pass = ?";

		//データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pass);

			//SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			//結果の操作
			if(res.next()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * アドミンチェック(会員か管理者のどっちでログインするか)
	 */
	public Boolean admin_flg_Check(String user_id) throws ClassNotFoundException, SQLException {

		String sql = "SELECT admin_flg FROM m_user WHERE user_id = ?";

		//初期化
		Boolean a = null;
		//データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);

			//SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			//結果の操作
			if(res.next()) {

				if(res.getBoolean("admin_flg")) {

					a = true;
				}
				else {
					a = false;

				}
			}
		} return a;
	}

	/**
	 * DBにログインした日付更新する
	 */
	public int Update_date(String user_id) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE m_user SET last_login_date = ? WHERE user_id = ?";

		//初期化
		int res = 0;
		//データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//現在の日付を取得
			java.sql.Date nowDate =
					new java.sql.Date(System.currentTimeMillis());

			// プレースホルダへの値の設定
			pstmt.setDate(1, nowDate);
			pstmt.setString(2, user_id);

			res = pstmt.executeUpdate();
		}

		return res;
	}

}
