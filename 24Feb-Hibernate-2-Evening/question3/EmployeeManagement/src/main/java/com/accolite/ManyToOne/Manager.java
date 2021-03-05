package com.accolite.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		UserDetails user = new UserDetails();

		Vehicle vehicle = new Vehicle(); 
		Vehicle vehicle2 = new Vehicle(); 

		vehicle.setVehicleName("Baleno Car"); 
		vehicle.setUser(user); 

		vehicle2.setVehicleName("Maritu 800 Car"); 
		vehicle2.setUser(user);

		user.setUserName("Virat Kohli");

		session.beginTransaction(); 
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}