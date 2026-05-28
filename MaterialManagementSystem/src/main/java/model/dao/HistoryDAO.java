package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.HistoryBean;

public class HistoryDAO {
	public List<HistoryBean> selectAll(String user_id) throws SQLException,ClassNotFoundException {
		List<HistoryBean> historyList = new ArrayList<HistoryBean>();
		String sql = "select * from history where user_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				HistoryBean historyBean = new HistoryBean();
				historyBean.setDate(res.getDate("date"));
				historyBean.setSweets_name(res.getString("sweets_name"));
				
				historyList.add(historyBean);
			}
			
		}
		
		return historyList;
	}
	
	public HistoryBean getDetail(String user_id,String sweetsName,Date date) throws SQLException,ClassNotFoundException {
		String sql = "select * from history where sweets_name = ? and date = ? and user_id = ?";
		HistoryBean historyBean = new HistoryBean();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1,sweetsName );
			pstmt.setDate(2,date );
			pstmt.setString(3,user_id);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				historyBean.setComment(res.getString("comment"));
				historyBean.setDate(res.getDate("date"));
				historyBean.setImage_name(res.getString("image_path"));
				historyBean.setRecipe_url(res.getString("recipe_url"));
				historyBean.setSweets_name(res.getString("sweets_name"));
			}
			
			
		}
		
		return historyBean;
	}
}
