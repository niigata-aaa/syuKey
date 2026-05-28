package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
