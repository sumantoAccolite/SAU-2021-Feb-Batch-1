package com.accolite.Ecommerce;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="ProductId")
	private int pid;
	@Column(name="ProductName")
	private String pname;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Categories.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ProductId")
	private Set<Categories> categories;
	
	public Set<Categories> getCategories(){
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}


}