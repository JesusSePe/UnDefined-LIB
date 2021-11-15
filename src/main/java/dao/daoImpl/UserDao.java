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
	
	public boolean getValidateLogin(String name, String password) {
		Transaction transaction = null;
		User user = null;
		boolean validate = false;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			user = session.get(User.class, name);
			if (password == user.getPassword())
			{
				validate = true;
				return validate;
				transaction.commit();
			}
			
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return validate;
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
				transaction.rollback();	
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
