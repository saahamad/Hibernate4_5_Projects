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

	/*
	 *  Named parameter [:nameofparameter] and Possitional parameter [?]
			Possitional parameter is depricated in Hibernate 4 and 5

		String hql = "FROM User user WHERE user.userName= ?";
		query.setParameter(0,name);
	*
	*/
	public List<User> searchNameRecord(Session session,String name){
			String hql = "FROM User user WHERE user.userName= :username";
			List<User> list = null;
			try {
			Query query = session.createQuery(hql);
			query.setParameter("username",name);
			list = query.list();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

	}
