package dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import dao.Dao;
import objects.UserAnswerHistory;

public class UserQuestionHistoryDao implements Dao<UserAnswerHistory> {

	@Override
	public UserAnswerHistory get(long id) {
		Transaction transaction = null;
		UserAnswerHistory userQuestionHistory = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			userQuestionHistory = session.get(UserAnswerHistory.class, id);

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
	public List<UserAnswerHistory> getAll() {
		Transaction transaction = null;
		List<UserAnswerHistory> players = new ArrayList<UserAnswerHistory>();

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
	public void save(UserAnswerHistory userQuestionHistory) {
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
	public void update(UserAnswerHistory userQuestionHistory) {
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
	public void delete(UserAnswerHistory userQuestionHistory) {
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
