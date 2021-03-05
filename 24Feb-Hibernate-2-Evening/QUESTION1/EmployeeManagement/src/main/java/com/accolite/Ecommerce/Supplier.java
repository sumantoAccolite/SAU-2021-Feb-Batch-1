package com.accolite.Ecommerce;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier {
	@Id
	@Column(name="SupplierId")
	private int sid;
	
	@Column(name="SupplierName")
	private String sname;
	
	@ManyToMany(targetEntity = Categories.class)
	@JoinColumn(referencedColumnName = "SupplierId")
	private Set<Categories> categories;
	
	public Set<Categories> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	

}