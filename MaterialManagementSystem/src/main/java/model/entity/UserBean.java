package model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ユーザーを表します。
 * m_userのDTOであり、Beanオブジェクトです。
 */
public class UserBean implements Serializable {
	/**
	 * ユーザーID
	 */
	private String user_id;

	/**
	 * パスワード
	 */
	private String user_pass;

	/**
	 * 管理者フラグ
	 */
	private Boolean admin_flg;

	/**
	 * 最終ログイン
	 */
	private Date last_login_date;


	public String getUser_id() {
		return user_id;
	}

	/**
	 * UserBeanを構築します。
	 */
	public UserBean() {

	}
	/**
	 * フィールドuser_idの値を設定します。
	 * @param user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * フィールドuser_idの値を返します。
	 * @param user_id
	 */
	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * フィールドuser_passの値を設定します。
	 * @param user_pass
	 */
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	/**
	 * フィールドuser_passの値を返します。
	 * @param user_pass
	 */
	public Boolean getAdmin_flg() {
		return admin_flg;
	}


	public void setAdmin_flg(Boolean admin_flg) {
		this.admin_flg = admin_flg;
	}


	public Date getLast_login_date() {
		return last_login_date;
	}


	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}


}
