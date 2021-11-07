package objects;

public class Player {
	
	private long playerId;
	private long userId;
	private long competitionId;
	private short score;
	
	public Player(long userId, long competitionId, short score) {
		super();
		this.userId = userId;
		this.competitionId = competitionId;
		this.score = score;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}
	
	
}
