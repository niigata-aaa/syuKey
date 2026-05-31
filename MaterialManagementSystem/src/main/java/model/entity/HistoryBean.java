package model.entity;

import java.io.Serializable;
import java.util.Date;

public class HistoryBean implements Serializable {
	private String user_id;
	private String sweets_name;
	private Date date;
	private String recipe_url;
	private String comment;
	private String image_name;
	private byte[] image_data;
	private String contentType;
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getImage_data() {
		return image_data;
	}

	public void setImage_data(byte[] image_data) {
		this.image_data = image_data;
	}

	public HistoryBean() {
		
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSweets_name() {
		return sweets_name;
	}
	public void setSweets_name(String sweets_name) {
		this.sweets_name = sweets_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRecipe_url() {
		return recipe_url;
	}
	public void setRecipe_url(String recipe_url) {
		this.recipe_url = recipe_url;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
}
