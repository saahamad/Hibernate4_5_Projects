package com.DAO;

import java.util.List;

import org.hibernate.Query;
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

	public List<User> recordsList(Session session){

		String hql = "From User user";
		return session.createQuery(hql).list();
	}

	public List<User> searchNameRecord(Session session,String name){

			String hql = "FROM User user WHERE user.userName='"+name+"'";
			List<User> list = null;
			try {
			list = session.createQuery(hql).list();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

	}
