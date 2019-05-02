package com.executors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.updatetomanytables.Employee;
import com.updatetomanytables.Laptop;

public class HibernateUpdateToManyTablesExecutor {
	
	    private static SessionFactory buildSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
	        		applySettings(configuration.getProperties()).build();	 	          
	        return configuration.buildSessionFactory(serviceRegistry);
	    }

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmpName("Sajjad");
		
		Laptop lap = new Laptop();
		lap.setLpName("Lenovo");
		
		Session session = buildSessionFactory().openSession();
		session.save(emp);
		session.save(lap);
		
		session.beginTransaction().commit();
		System.out.println("Transaction completed...");		
	}	
}
