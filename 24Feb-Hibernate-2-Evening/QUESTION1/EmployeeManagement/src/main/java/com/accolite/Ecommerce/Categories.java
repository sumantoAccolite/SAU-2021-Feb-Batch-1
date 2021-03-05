package com.accolite.Ecommerce;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Categories")
public class Categories {
	@Id
	@Column(name="CategoryId")
	private int cid;
	@Column(name="CategoryName")
	private String cname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ProductId")
	private Product product;
	
	@ManyToMany(targetEntity = Supplier.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Categories_Supplier", 
	joinColumns = @JoinColumn(referencedColumnName = "CategoryId"), 
	inverseJoinColumns = @JoinColumn(referencedColumnName = "SupplierId"))
	private Set<Supplier> supplier;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Set<Supplier> getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}	
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}


}
