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
		String sql = "INSERT INTO user(user_id, user_pass) VALUES(?,?)";
		int result = 0;

		//データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//プレースホルダーへの値の設定
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_pass());

			//SQLステートメントの実行
			result = pstmt.executeUpdate();
		}
		return result;
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
	public int delete(String[] userList) throws ClassNotFoundException,SQLException{
		
		if (userList == null) {
			return 0;
		}
		//選択されたユーザIDからIN句の条件を作成
		
	}
}
