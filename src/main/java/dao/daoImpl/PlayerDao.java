package dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import dao.Dao;
import objects.Player;

public class PlayerDao implements Dao<Player>{
	
	public PlayerDao() {
		
	}

	@Override
	public Player get(long id) {
		Transaction transaction = null;
		Player player = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			player = session.get(Player.class, id);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return player;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAll() {
		Transaction transaction = null;
		List<Player> players = new ArrayList<Player>();

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			players = session.createQuery("from player").list();

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return players;
	}

	@Override
	public void save(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.save(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}

	@Override
	public void update(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.saveOrUpdate(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
	}

	@Override
	public void delete(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.delete(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

	}

}
