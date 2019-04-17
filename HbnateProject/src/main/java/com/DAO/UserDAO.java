package com.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.User;

public class UserDAO {
	
	public void insertRecord(User user,Session session,Transaction transaction) {
		try {
		session.save(user);
		transaction.commit();
		System.out.println("User record inserted..");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();			
		}
	}
	
	public void accessRecord(int userId,Session session) {
		try {
			User user = (User) session.get(User.class,userId);	
			
			System.out.println("User Name.."+user.getUserName());
			System.out.println("User Id...."+user.getUserId());
			System.out.println("User date.."+user.getDate());
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();			
			}
	}

}
