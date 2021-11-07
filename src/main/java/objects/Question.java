package objects;

public class Question {
	
	private long questionId;
	private String question;
	private long questionTypeId;
	private long timeout;
	private long kahootId;
	
	public Question(String question, long questionTypeId, long timeout, long kahootId) {
		super();
		this.question = question;
		this.questionTypeId = questionTypeId;
		this.timeout = timeout;
		this.kahootId = kahootId;
	}
	
	public long getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public long getQuestionTypeId() {
		return questionTypeId;
	}
	
	public void setQuestionTypeId(long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	
	public long getTimeout() {
		return timeout;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	public long getKahootId() {
		return kahootId;
	}
	
	public void setKahootId(long kahootId) {
		this.kahootId = kahootId;
	}
	
}
