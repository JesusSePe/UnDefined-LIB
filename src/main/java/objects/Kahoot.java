package objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Column(name = "description")
	private String description;

	@Column(name = "language")
	private String language;

	@Column(name = "image")
	private String image;

	@Column(name = "time_plays")
	private long timePlays;

	@Column(name = "totalPlayers")
	private long totalPlayers;

	@Column(name = "is_favorite")
	private boolean isFavorite;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "kahoot_topic", joinColumns = { @JoinColumn(name = "kahoot_id") }, inverseJoinColumns = {
			@JoinColumn(name = "topic_id") })
	private List<Topic> topics;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "kahoot", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Question> questions;

	@OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL)
	private List<Competition> competitions;

	public Kahoot() {
		super();
	}

	public Kahoot(String title, String description, String language, String image, boolean isFavorite) {
		super();
		this.title = title;
		this.description = description;
		this.language = language;
		this.image = image;
		this.isFavorite = isFavorite;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getTimePlays() {
		return timePlays;
	}

	public void setTimePlays(long timePlays) {
		this.timePlays = timePlays;
	}

	public long getTotalPlayers() {
		return totalPlayers;
	}

	public void setTotalPlayers(long totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
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

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

}
