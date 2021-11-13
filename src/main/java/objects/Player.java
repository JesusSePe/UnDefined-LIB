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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private long playerId;

	@Column(name = "nickname")
	private String nickname;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "competition_player", joinColumns = { @JoinColumn(name = "player_id") }, inverseJoinColumns = {
			@JoinColumn(name = "competition_id") })
	private List<Competition> competitions;

	@OneToMany(mappedBy = "player", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<UserQuestionHistory> userQuestionHistories;

	public Player() {
		super();
	}

	public Player(String nickname) {
		super();
		this.nickname = nickname;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public List<UserQuestionHistory> getUserQuestionHistories() {
		return userQuestionHistories;
	}

	public void setUserQuestionHistories(List<UserQuestionHistory> userQuestionHistories) {
		this.userQuestionHistories = userQuestionHistories;
	}

}
