package objects;

public class Competition {
	
	private long competitionId;
	private long kahootId;
	
	public Competition(long kahootId) {
		super();
		this.kahootId = kahootId;
	}

	public long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}

	public long getKahootId() {
		return kahootId;
	}

	public void setKahootId(long kahootId) {
		this.kahootId = kahootId;
	}
	
	
}
