package com.executors;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.DAO.UserDAO;
import com.entities.User;

public class HibernateExecutor {

	    static User user = null;
	    static Session session = null;
	    static SessionFactory sessionFactory = null;
	    static Transaction transaction;
	    static Scanner scanner = null;
	    UserDAO userDao = new UserDAO();

	    private static SessionFactory buildSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
	        		applySettings(configuration.getProperties()).build();
	        return configuration.buildSessionFactory(serviceRegistry);
	    }

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		System.out.println("Select------------1 for (save record)");
		System.out.println("Select------------2 for (get a record)");
		System.out.println("Select------------3 for (get all records)");
		System.out.println("Select------------4 for (get all records)");

		int choice = scanner.nextInt();
		new HibernateExecutor().getTransactions(choice);
	}

	public void getTransactions(int choice) {

		switch (choice) {
		case 1:

			session = buildSessionFactory().openSession();
			transaction = session.beginTransaction();

			// Object preparation for mapping
			User user = new User();
			System.out.println("Enter a name:");
			user.setDate(new Date());
			user.setUserName(scanner.next());

			userDao.insertRecord(user,session,transaction);
			break;

        case 2:

        	session = buildSessionFactory().openSession();
        	System.out.println("Enter record id:");
        	userDao.accessRecord(scanner.nextInt(), session);
			break;

        case 3:
        	session = buildSessionFactory().openSession();
        	List<User> list = userDao.recordsList(session);
        	for(User userObj:list)
        	System.out.println("\n Id is:"+userObj.getUserId()+"\n Name is:"+userObj.getUserName()+"\n Date is:"+userObj.getDate());

			break;

        case 4:
        	session = buildSessionFactory().openSession();
        	System.out.println("Enter a name!");
        	List<User> userList = userDao.searchNameRecord(session,scanner.next());
        	for(User userObj:userList)
        	System.out.println("\n Id is:"+userObj.getUserId()+"\n Name is:"+userObj.getUserName()+"\n Date is:"+userObj.getDate());

			break;

		default:
			System.out.println("Sorry for invalid transaction!");
		}

	}
}
