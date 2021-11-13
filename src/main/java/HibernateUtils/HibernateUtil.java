package HibernateUtils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import objects.Answer;
import objects.Competition;
import objects.Kahoot;
import objects.Player;
import objects.Question;
import objects.QuestionType;
import objects.Topic;
import objects.User;
import objects.UserQuestionHistory;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Kadam?serverTimezone=UTC");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Answer.class);
				configuration.addAnnotatedClass(Competition.class);
				configuration.addAnnotatedClass(Kahoot.class);
				configuration.addAnnotatedClass(Player.class);
				configuration.addAnnotatedClass(Question.class);
				configuration.addAnnotatedClass(QuestionType.class);
				configuration.addAnnotatedClass(Topic.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(UserQuestionHistory.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config Service Registry Created");

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
