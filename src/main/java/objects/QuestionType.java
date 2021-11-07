package objects;

public class QuestionType {
	
	private long questionTypeId;
	private String questionType;
	
	public QuestionType(String questionType) {
		super();
		this.questionType = questionType;
	}

	public long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	
}
