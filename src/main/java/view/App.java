package view;

import dao.daoImpl.PlayerDao;
import dao.daoImpl.QuestionDao;
import dao.daoImpl.TypeQDao;
import dao.daoImpl.UserDao;
import objects.Player;
import objects.Question;
import objects.TypeQ;
import objects.User;

public class App {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		PlayerDao playerDao = new PlayerDao();
		TypeQDao typeQDao = new TypeQDao();
		QuestionDao questionDao = new QuestionDao();

		User user1 = new User("ladyangel", "angiemarie@hotmail.com", "12345");
		userDao.save(user1);
		User user2 = new User("lady", "angiemarie1@hotmail.com", "12345");
		userDao.save(user2);

		User user3 = userDao.get(1);

		Player player1 = new Player(user1, 795);
		Player player2 = new Player(user1, 435);
		Player player3 = new Player(user2, 1256);
		Player player4 = new Player(user2, 952);

		playerDao.save(player1);
		playerDao.save(player2);
		playerDao.save(player3);
		playerDao.save(player4);

		TypeQ questionType1 = new TypeQ("Dicotomica");
		TypeQ questionType2 = new TypeQ("Monorespuesta");
		TypeQ questionType3 = new TypeQ("Multirespuesta");
		TypeQ questionType4 = new TypeQ("Escrita");

		typeQDao.save(questionType1);
		typeQDao.save(questionType2);
		typeQDao.save(questionType3);
		typeQDao.save(questionType4);

		Question question1 = new Question("blablablablablabla", 30);
		Question question2 = new Question("blablablablablabla", 30);
		Question question3 = new Question("blablablablablabla", 10);

		question1.setTypeQ(questionType3);
		question2.setTypeQ(questionType2);
		question3.setTypeQ(questionType1);

		questionDao.save(question1);
		questionDao.save(question2);
		questionDao.save(question3);

	}

}
