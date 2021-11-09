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
@Table(name = "kahoot")
public class Kahoot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kahoot_id")
	private long kahootId;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id")
	private Topic topic;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "kahoot", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Question> questions;

	@OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL)
	private List<Competition> competition;

	public Kahoot() {
		super();
	}

	public Kahoot(String title, User user) {
		super();
		this.title = title;
		this.user = user;
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

	/*
	 * public Topic getTopic() { return topic; }
	 * 
	 * public void setTopic(Topic topic) { this.topic = topic; }
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*
	 * public List<Question> getQuestions() { return questions; }
	 * 
	 * public void setQuestions(List<Question> questions) { this.questions =
	 * questions; }
	 */

	public List<Competition> getCompetition() {
		return competition;
	}

	public void setCompetition(List<Competition> competition) {
		this.competition = competition;
	}

}
