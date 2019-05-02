package com.executors;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.onetomany.EmployeeMany;
import com.onetomany.LaptopMany;


public class HibernateOneToManyExecutor {
	
	    private static SessionFactory buildSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
	        		applySettings(configuration.getProperties()).build();	 	          
	        return configuration.buildSessionFactory(serviceRegistry);
	    }

	public static void main(String[] args) {
		
		List<LaptopMany> laptops = new ArrayList<>();
		
		EmployeeMany emp = new EmployeeMany();
		emp.setEmpName("Areeb");
		
		
		LaptopMany lap1 = new LaptopMany();
		lap1.setLpName("Dell");
		
		LaptopMany lap2 = new LaptopMany();
		lap2.setLpName("HP");
		
		laptops.add(lap1);
		laptops.add(lap2);		
		emp.setLaptop(laptops);
		
		
		Session session = buildSessionFactory().openSession();
		session.save(emp);
		session.save(lap1);
		session.save(lap2);
		
		session.beginTransaction().commit();
		System.out.println("Transaction completed...");		
	}	
}
