package dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import dao.Dao;
import objects.UserQuestionHistory;

public class UserQuestionHistoryDao implements Dao<UserQuestionHistory> {

	@Override
	public UserQuestionHistory get(long id) {
		Transaction transaction = null;
		UserQuestionHistory userQuestionHistory = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			userQuestionHistory = session.get(UserQuestionHistory.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return userQuestionHistory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserQuestionHistory> getAll() {
		Transaction transaction = null;
		List<UserQuestionHistory> players = new ArrayList<UserQuestionHistory>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			players = session.createQuery("from user_question_history").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return players;
	}

	@Override
	public void save(UserQuestionHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public void update(UserQuestionHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void delete(UserQuestionHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.delete(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
