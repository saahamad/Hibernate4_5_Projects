package com.executors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.onetoone.EmployeeOne;
import com.onetoone.LaptopOne;

public class HibernateOneToOneExecutor {
	
	    private static SessionFactory buildSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
	        		applySettings(configuration.getProperties()).build();	 	          
	        return configuration.buildSessionFactory(serviceRegistry);
	    }

	public static void main(String[] args) {
		
		EmployeeOne emp = new EmployeeOne();
		emp.setEmpName("Sarfaraz");
		
		
		LaptopOne lap = new LaptopOne();
		lap.setLpName("Dell");
		
		emp.setLaptop(lap);
		
		
		Session session = buildSessionFactory().openSession();
		session.save(emp);
		session.save(lap);
		
		session.beginTransaction().commit();
		System.out.println("Transaction completed...");		
	}	
}
