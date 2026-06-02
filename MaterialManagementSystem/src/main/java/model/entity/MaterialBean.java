package model.entity;

import java.io.Serializable;
import java.util.Date;

public class MaterialBean implements Serializable {
	private String material_name;
	private String material_kana;
	private int amount;
	private String material_unit;
	private Date material_limit;
	private String limits;
	private int material_id;
	private int unit_id;
	private String amounts;
	
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public int getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}
	public String getLimits() {
		return limits;
	}
	public void setLimits(String limits) {
		this.limits = limits;
	}
	public MaterialBean() {
		
	}
	
	private String user_id;
	
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getMaterial_kana() {
		return material_kana;
	}
	public void setMaterial_kana(String material_kana) {
		this.material_kana = material_kana;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMaterial_unit() {
		return material_unit;
	}
	public void setMaterial_unit(String material_unit) {
		this.material_unit = material_unit;
	}
	public Date getMaterial_limit() {
		return material_limit;
	}
	public void setMaterial_limit(Date material_limit) {
		this.material_limit = material_limit;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
