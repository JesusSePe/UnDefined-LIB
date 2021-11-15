package objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "competition")
public class Competition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "competition_id")
	private long competitionId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Kahoot kahoot;

	@ManyToMany(mappedBy = "competitions")
	private List<Player> players;

	@OneToMany(mappedBy = "competition", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<UserAnswerHistory> userQuestionHistories;

	public Competition() {
		super();
	}

	public Competition(Kahoot kahoot) {
		super();
		this.kahoot = kahoot;
	}

	public long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}

	public Kahoot getKahoot() {
		return kahoot;
	}

	public void setKahoot(Kahoot kahoot) {
		this.kahoot = kahoot;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<UserAnswerHistory> getUserQuestionHistories() {
		return userQuestionHistories;
	}

	public void setUserQuestionHistories(List<UserAnswerHistory> userQuestionHistories) {
		this.userQuestionHistories = userQuestionHistories;
	}

}
