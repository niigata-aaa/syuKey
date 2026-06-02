package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.MaterialBean;

public class MaterialDAO {

	public List<MaterialBean> selectAll() throws SQLException,ClassNotFoundException{

		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select m.material_name,sum(m.material_amount) as total_amount ,m.unit_name,group_concat(material_limit) as limits from ( select * from m_material inner join m_unit on m_material.material_unit_id = m_unit.unit_id) as m where m.material_amount is not null group by material_name,unit_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setAmount(res.getInt("total_amount"));
				materialBean.setMaterial_name(res.getString("material_name"));
				materialBean.setMaterial_unit(res.getString("unit_name"));
				materialBean.setLimits(res.getString("limits"));
				//materialBean.setMaterial_limit(res.getDate("material_limit")); 
				materialList.add(materialBean);
			}
		} 

		return materialList;
	}

	public List<MaterialBean> selectLimits() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select material_name,group_concat(material_limit) as limits from m_material group by material_name having limits is not null";
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
		String sql = "select material_name,material_limit from m_material where material_amount is not null";
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

	public List<MaterialBean> selectNameUnitList() throws SQLException,ClassNotFoundException{

		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select material_name,material_kana,unit_name from m_material inner join m_unit on m_material.material_unit_id = m_unit.unit_id group by material_name,material_kana,unit_name";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));
				materialBean.setMaterial_kana(res.getString("material_kana"));
				materialBean.setMaterial_unit(res.getString("unit_name"));

				materialList.add(materialBean);
			}

		}

		return materialList;
	}

	public List<String> selectNameList() throws SQLException,ClassNotFoundException{

		List<String> nameList = new ArrayList<String>();
		String sql = "select material_name from m_material group by material_name";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				String name = res.getString("material_name");

				nameList.add(name);
			}

		}

		return nameList;
	}

//	public List<String> selectAllUnit() throws SQLException,ClassNotFoundException{
//
//		List<String> nameList = new ArrayList<String>();
//		String sql = "select unit_name from m_unit";
//
//		try(Connection con = ConnectionManager.getConnection();
//				PreparedStatement pstmt = con.prepareStatement(sql)){
//
//			ResultSet res = pstmt.executeQuery();
//
//			while(res.next()) {
//				String name = res.getString("unit_name");
//
//				nameList.add(name);
//			}
//
//		}
//
//		return nameList;
//	}
	
	public List<MaterialBean> selectAllUnit() throws SQLException,ClassNotFoundException{

		List<MaterialBean> unitList = new ArrayList<MaterialBean>();
		String sql = "select unit_id,unit_name from m_unit";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setUnit_id(res.getInt("unit_id"));
				materialBean.setMaterial_unit(res.getString("unit_name"));

				unitList.add(materialBean);
			}

		}

		return unitList;
	}

	public int regist(MaterialBean materialBean) throws SQLException,ClassNotFoundException{
		String sql="update m_material set material_amount = ?,material_limit = ? where material_name=? AND material_amount is null";
		int cnt = 0;


		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			//System.out.println(materialBean.getLimits());
			//java.sql.Date sqlDate = new java.sql.Date(materialBean.getMaterial_limit().getTime());

			System.out.println(materialBean.getAmount() + "と" +materialBean.getMaterial_name()+ "と" + "と");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date sqlDate = null;

			try {
				java.util.Date utilDate = sdf.parse(materialBean.getLimits());
				sqlDate = new java.sql.Date(utilDate.getTime());

			} catch(Exception e) {
				e.printStackTrace();
			}

			pstmt.setInt(1, materialBean.getAmount());
			pstmt.setDate(2, sqlDate);
			pstmt.setString(3, materialBean.getMaterial_name());

			cnt = pstmt.executeUpdate();

		}
		return cnt;
	}

	public MaterialBean  select(String materialName,Date materialLimit) 
			throws SQLException, ClassNotFoundException {

		String sql = "SELECT t1.material_id,t1.material_unit_id, t1.material_name,t1.material_kana,t1.material_amount,t1.material_limit,"
				+ "t2.unit_name "
				+ "FROM m_material t1 INNER JOIN  m_unit t2 ON t1.material_unit_id = t2.unit_id WHERE Material_name = ? AND material_limit = ?";

		MaterialBean material = new MaterialBean ();


		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, materialName);
			java.sql.Date dateS = new java.sql.Date(materialLimit.getTime());
			//java.sql.Date materialLimitS = materialLimit.getTime();
			pstmt.setDate(2, dateS);


			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				int material_id = res.getInt("material_id");
				String material_name = res.getString("material_name");
				String material_kana = res.getString("material_kana");
				Date material_limit = res.getDate("material_limit");
				int  material_amount = res.getInt("material_amount");
				String  material_unit = res.getString("unit_name");


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

		String sql = "update m_material set material_amount = null, material_limit = null WHERE material_id = ?";
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

	public List<MaterialBean> selectAllName() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialNameList = new ArrayList<MaterialBean>();
		String sql = "select material_name from m_material group by material_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));

				materialNameList.add(materialBean);
			}
		}
		return materialNameList;
	}
	public List<MaterialBean> selectDeleteName() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialNameList = new ArrayList<MaterialBean>();
		String sql = "select material_name from m_material where material_id > 40 group by material_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));

				materialNameList.add(materialBean);
			}
		}
		return materialNameList;
	}
	public List<MaterialBean> selectDeleteNameAdmin() throws SQLException,ClassNotFoundException {
		List<MaterialBean> materialNameList = new ArrayList<MaterialBean>();
		String sql = "select material_name from m_material group by material_name";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setMaterial_name(res.getString("material_name"));

				materialNameList.add(materialBean);
			}
		}
		return materialNameList;
	}

	public int NewMaterialDelete(MaterialBean material) throws SQLException, ClassNotFoundException {
		int cnt = 0;
		String sql = "delete from m_material where material_name = ? AND user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			String material_name = material.getMaterial_name();
			String user_id = material.getUser_id();

			pstmt.setString(1, material_name);
			pstmt.setString(2, user_id);

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
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
	public List<MaterialBean> selectToUpdate(String material_name) throws SQLException,ClassNotFoundException{
		List<MaterialBean> materialList = new ArrayList<MaterialBean>();
		String sql = "select material_id,material_limit,material_amount from m_material where material_name = ? ORDER BY material_limit ASC";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, material_name);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				MaterialBean materialBean = new MaterialBean();
				materialBean.setAmount(res.getInt("material_amount"));
				materialBean.setMaterial_limit(res.getDate("material_limit"));
				materialBean.setMaterial_id(res.getInt("material_id"));
				
				materialList.add(materialBean);
			}
			
			

		}


		return materialList;
	}
	
	public int update(List<MaterialBean> materialList) throws SQLException,ClassNotFoundException {
		int count = 0;
		String sql = "update m_material set material_amount = ? where material_id = ?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			for(int i=0;i<materialList.size();i++) {
				pstmt.setInt(1,materialList.get(i).getAmount());
				pstmt.setInt(2, materialList.get(i).getMaterial_id());
				count += pstmt.executeUpdate();
			}
		}
		
		sql = "update m_material set material_amount = null,material_limit = null where material_amount = 0";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.executeUpdate();
		}
		
		
		return count;
	}
	
	public int getTotalAmount(String material_name) throws SQLException,ClassNotFoundException{
		String sql = "select sum(material_amount) as total_amount from m_material where material_name = ?";
		int total_amount = 0;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, material_name);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				total_amount=res.getInt("total_amount");
			}
		}
		
		return total_amount;
	}
	
	public int insert(String materialName,java.sql.Date materialLimit,int amount,int unitId,String userId) throws SQLException,ClassNotFoundException{
		int cnt = 0;
		String sql = "insert into m_material(material_name,material_amount,material_unit_id,material_limit,user_id) values(?,?,?,?,?)";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, materialName);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, unitId);
			pstmt.setDate(4,materialLimit);
			pstmt.setString(5, userId);
			
			cnt += pstmt.executeUpdate();
		}
		
		sql = "insert into m_material(material_name,material_unit_id,user_id) values(?,?,?)";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, materialName);
			pstmt.setInt(2, unitId);
			pstmt.setString(3, userId);
			
			cnt += pstmt.executeUpdate();
		}
		return cnt;
	}

}
