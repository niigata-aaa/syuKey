package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		String sql = "select * from history where user_id = ? order by date desc";
		
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
				historyBean.setImage_data(res.getBytes("data"));
				historyBean.setSweets_name(res.getString("sweets_name"));
				historyBean.setContentType(res.getString("contentType"));
			}
			
			
		}
		
		return historyBean;
	}
	
	public int insert(String user_id,String url,String sweets_name,String comment,String fileName,String filePath,String contentType) throws SQLException,ClassNotFoundException, IOException{
		int cnt = 0;
		String sql = "INSERT INTO history  VALUES (?,?,?,?,?,?,?,?)";
		File file = new File(filePath);
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			try(FileInputStream fis = new FileInputStream(file)){
				java.util.Date nowDate = new java.util.Date();
				java.sql.Date sqlDate = null;
				try {
					
					sqlDate = new java.sql.Date(nowDate.getTime());
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			    pstmt.setString(1, user_id);
			    pstmt.setString(2, sweets_name);
			    pstmt.setDate(3, sqlDate);
			    pstmt.setString(4, fileName);
			    pstmt.setString(5, url);
			    pstmt.setString(6,comment);
			    pstmt.setBlob(7, fis);
			    pstmt.setString(8, contentType);
			    
			    cnt = pstmt.executeUpdate();
			    
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
}
