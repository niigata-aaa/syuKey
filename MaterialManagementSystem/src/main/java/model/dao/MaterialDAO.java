package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.MaterialBean;

public class MaterialDAO {

	public List<MaterialBean> selectAll() throws SQLException,ClassNotFoundException{

		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select m.material_name,sum(m.material_amount) as total_amount ,m.unit_name from ( select * from m_material inner join m_unit on m_material.material_unit_id = m_unit.unit_id) as m group by material_name,unit_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setAmount(res.getInt("total_amount"));
				materialBean.setMaterial_name(res.getString("material_name"));
				materialBean.setMaterial_unit(res.getString("unit_name"));
				//materialBean.setMaterial_limit(res.getDate("material_limit")); 
				materialList.add(materialBean);
			}
		} 

		return materialList;
	}

	public List<MaterialBean> selectLimits() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select material_name,group_concat(material_limit) as limits from m_material group by material_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));
				
				materialBean.setLimits(res.getString("limits"));
				
				materialList.add(materialBean);
			}

		}
		
		return materialList;
	}
	
	public List<MaterialBean> selectAllLimit() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select material_name,material_limit from m_material";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));
				
				materialBean.setMaterial_limit(res.getDate("material_limit"));
				
				materialList.add(materialBean);
			}

		}
		
		return materialList;
	}
	
	public MaterialBean  select(String materialName,Date materialLimit) 
			throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT t1.material_unit_id, t2.unit_id "
				+ "FROM m_material t1 INNER JOIN  m_unit t2 ON t1.material_unit_id = t2.unit_id ";
		
		
		 String sql2 = "SELECT * FROM m_material WHERE Material_name = ? AND material_limit = ?";
		
		 MaterialBean material = new MaterialBean ();
			
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2)) {

			// プレースホルダへの値の設定
			pstmt2.setString(1, materialName);
			java.sql.Date dateS = new java.sql.Date(materialLimit.getTime());
			//java.sql.Date materialLimitS = materialLimit.getTime();
			pstmt2.setDate(2, dateS);

			
			ResultSet res2 = pstmt2.executeQuery();
			
			while (res2.next()) {
				
				int material_id = res2.getInt("material_id");
				String material_name = res2.getString("material_name");
				String material_kana = res2.getString("material_kana");
				Date material_limit = res2.getDate("material_limit");
				int  material_amount = res2.getInt("material_amount");
				String  material_unit = res2.getString("unit_name");
				
				
				material.setMaterial_id(material_id);
				material.setMaterial_name(material_name);
				material.setMaterial_kana(material_kana);
				
				java.sql.Date sqlDate = null;
				
				try {
					sqlDate = new java.sql.Date(material_limit.getTime());
					sqlDate = new java.sql.Date(sqlDate.getTime());
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				material.setMaterial_limit(sqlDate);
				material.setAmount(material_amount);
				material.setMaterial_unit(material_unit);
			}
			
		
	} return material;
	}
	
	public int delete(int material_id) 
			throws ClassNotFoundException{
	
		String sql = "DELETE FROM m_material WHERE material_id = ?";
		int cnt = 0;
		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, material_id);

            // SQLを実行
             cnt = pstmt.executeUpdate();
            	
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return cnt;
    }
}
