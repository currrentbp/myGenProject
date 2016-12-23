package com.bp.annotation.test;

/**
 * 
 * @author current_bp
 * @createTime 20161008
 *
 */
@TableAnnotation("person")
public class PersonAnnotation {

	@ColumnAnnotation("id")
	private Long id;
	@ColumnAnnotation("name")
	private String name;
	@ColumnAnnotation("address")
	private String address;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
