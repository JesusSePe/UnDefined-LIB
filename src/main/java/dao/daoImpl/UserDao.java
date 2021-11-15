package dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import dao.Dao;
import objects.User;

public class UserDao implements Dao<User>{


	public UserDao() {

	}

	@Override
	public User get(long id) {
		Transaction transaction = null;
		User user = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			user = session.get(User.class, id);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Transaction transaction = null;
		List<User> users = new ArrayList<User>();

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			users = session.createQuery("from user").list();

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				// transaction.rollback();
				System.out.println(e);
			}
		}

		return users;
	}

	@Override
	public void save(User user) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}


	@Override
	public void update(User user) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.saveOrUpdate(user);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

	}

	@Override
	public void delete(User user) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.delete(user);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

	}

}
