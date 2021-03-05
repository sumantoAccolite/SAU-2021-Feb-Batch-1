package com.accolite.Ecommerce;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.util.Util;

public class Manager 
{
    public static void main( String[] args )
    {
    	Session session = Util.getSession();

		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		

		Categories c1 = new Categories();
		Categories c2 = new Categories();
		Categories c3 = new Categories();

		Supplier s1 = new Supplier();
		Supplier s2 = new Supplier();
		Supplier s3 = new Supplier();
		
		p1.setPid(1);
		p1.setPname("Laptop");
		p2.setPid(2);
		p2.setPname("Phone");
		p3.setPid(3);
		p3.setPname("TV");
		
		
		c1.setCid(1);
		c1.setCname("Apple");
		c2.setCid(2);
		c2.setCname("LG");
		c3.setCid(3);
		c3.setCname("Hitachi");
		
		s1.setSid(1);
		s1.setSname("S1");
		s2.setSid(2);
		s2.setSname("S2");
		s3.setSid(3);
		s3.setSname("S3");
		
		Set<Categories> Categoryset1 = new HashSet<>();
		Categoryset1.add(c1);
		Categoryset1.add(c3);
		
		p1.setCategories(Categoryset1);
		
		Set<Categories> Categoryset2 = new HashSet<>();
		Categoryset2.add(c2);
		
		p2.setCategories(Categoryset2);
		
		
		c1.setProduct(p1);
		c2.setProduct(p3);
		c3.setProduct(p1);
		
		Set<Supplier> Supplierset1 = new HashSet<>();
		Supplierset1.add(s1);
		Supplierset1.add(s3);
		
		Set<Supplier> Supplierset2 = new HashSet<>();
		Supplierset2.add(s2);
		
		s1.setCategories(Categoryset2);
		s2.setCategories(Categoryset1);
		s3.setCategories(Categoryset2);
		
		c1.setSupplier(Supplierset2);
		c2.setSupplier(Supplierset1);
		c3.setSupplier(Supplierset2);
		

		Transaction tx = session.beginTransaction();

		session.save(p1);
		session.save(p2);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(s1);
		session.save(s2);
		session.save(s3);
	
		tx.commit();
		session.close();
		
    }
}
