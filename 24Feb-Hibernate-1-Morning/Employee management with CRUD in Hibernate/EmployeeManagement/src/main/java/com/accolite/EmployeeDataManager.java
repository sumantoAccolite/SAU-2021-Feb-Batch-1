package com.accolite;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("deprecation")
public class EmployeeDataManager {  
static Scanner s= new Scanner(System.in);
public static void main(String[] args) {
	int choice=0,eid=0;
	boolean repeatOn=true;
	while(repeatOn){
		System.out.println("Enter your choice to perform actions on Employee database : 1-Add Employee ,2-UpdateAllEmployee, 3-Update by id, 4-Remove by id,  5-GetAllEmployees,6. Get employee by id, 7-Exit");
		choice = s.nextInt();
	switch(choice){
	case 1: addEmployee();
	        break;
	      
	case 2: updateAllEmployee();
			break;
			
	case 3: System.out.println("Enter id to update Employee Details");
			eid = s.nextInt();
			updateEmployee(eid);
			break;
			
	case 4: System.out.println("Enter id to remove Employee Details");
			eid = s.nextInt();
			removeEmployee(eid);
			break;
			
	case 5 : getAllEmployees();
			 break;
			
	case 6: System.out.println("Enter id to display Employee Details");
			eid = s.nextInt();
	        getEmployee(eid);
	        break;
	
	case 7 : System.out.println("Exiting....Bye");
	 		 repeatOn=false;
	 		 
	default: break;
		}
	}
}

public static void addEmployee(){
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();
    try{
	Transaction tnx = session.beginTransaction();
	Employee e1=new Employee(); 
	System.out.println("Enter First Name:");
	e1.setFname(s.nextLine());
	System.out.println("Enter Last Name:");
	e1.setLname(s.nextLine());
	System.out.println("Enter Designation:");
	e1.setDesignation(s.nextLine());
	System.out.println("Enter DOB:");
	Date d = java.sql.Date.valueOf(s.nextLine());
	e1.setDob(d);
	System.out.println("Enter Age:");
	e1.setAge(s.nextInt());
	System.out.println("Enter Salary:");
	e1.setSalary(s.nextInt());
	session.save(e1);
	tnx.commit();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully saved....");
	}
  }

public static void updateAllEmployee() {
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();
    try{
	Transaction tnx = session.beginTransaction();
	System.out.println("Enter new designation you want to update");
	s.nextLine();
	String newDesignation = s.nextLine();
	Query query = session.createQuery("from Employee");
    List<Employee> empList = query.list();
	if(empList == null)
		System.out.println("No Employee exists!");
	else{
		for(Employee emp : empList) {
			emp.setDesignation(newDesignation);
			session.update(emp);
		}
	
	tnx.commit();
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully Updated....");
	}
}

public static void updateEmployee(int id){
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();
    try{
	Transaction tnx = session.beginTransaction();
	System.out.println("Enter new designation you want to update");
	s.nextLine();
	String newDesignation = s.nextLine();
	Employee emp = (Employee) session.get(Employee.class, id);
	if(emp == null)
		System.out.println("No Employee exists with such Id, please re-enter correct id");
	else{
	emp.setDesignation(newDesignation);
	session.update(emp);
	System.out.println("Updated Employee Details are: ");
	System.out.println("Name - " + emp.getFname() + emp.getLname());
	System.out.println("Designation - " + emp.getDesignation());
	System.out.println("Date of Birth -  " + emp.getDob());
	tnx.commit();
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully Updated....");
	}
}


public static void removeEmployee(int id){
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();
    try{
	Transaction tnx = session.beginTransaction();
	Employee emp = (Employee) session.get(Employee.class, id);
	if(emp == null)
		System.out.println("No Employee exists with such Id, please re-enter correct id");
	else{
	session.delete(emp);
	tnx.commit();
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully Deleted....");
	}
}

private static void getAllEmployees() {
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();
    try{
	Query q= session.createQuery("from Employee");
	List<Employee> employees = (List<Employee>)q.list();
	for (Employee temp : employees) {
		System.out.println(temp.getEid()+", "+temp.getFname()+", "+temp.getLname()+", "+temp.getDesignation());
	}
    }
    catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully Retrieved....");
	}
}
 

public static void getEmployee(int id){
	SessionFactory sessionfactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionfactory.openSession();

	try{
	Transaction tnx = session.beginTransaction();
	Employee emp = (Employee) session.get(Employee.class, id);
	if(emp == null)
		System.out.println("No Employee exists with such Id, please re-enter correct id");
	else{
	System.out.println("Employee Details are: ");
	System.out.println("Name - " + emp.getFname() + emp.getLname());
	System.out.println("Designation - " + emp.getDesignation());
	System.out.println("Date of Birth -  " + emp.getDob());
	System.out.println("Age -  " + emp.getAge());
	System.out.println("Salary -  " + emp.getSalary());
	tnx.commit();
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally{
		session.close();
		System.out.println("Successfully Retrieved....");
	}
}


}
