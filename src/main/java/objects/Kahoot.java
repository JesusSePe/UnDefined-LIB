package objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "kahoot")
public class Kahoot {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "kahoot_id")
	private long kahootId;
	
	@Column(name = "title")
	private String title;
	
	//TODO revisar relacion
	@OneToMany(mappedBy = "kahoot", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<Topic> topics;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "kahoot", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<Question> questions;
	
	public Kahoot() {
		super();
	}

	public Kahoot(String title, List<Topic> topics, User user, List<Question> questions) {
		super();
		this.title = title;
		this.topics = topics;
		this.user = user;
		this.questions = questions;
	}

	public long getKahootId() {
		return kahootId;
	}

	public void setKahootId(long kahootId) {
		this.kahootId = kahootId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Kahoot [kahootId=" + kahootId + ", title=" + title + ", topics=" + topics + ", user=" + user
				+ ", questions=" + questions + "]";
	}
	
}
