package objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private long questionId;
	
	@Column(name = "question")
	private String question;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionType_id")
	private QuestionType questionType;
	
	@Column(name = "timeout")
	private long timeout;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kahoot_id")
	private Kahoot kahoot;
	
	public Question() {
		super();
	}
	
	public Question(String question, QuestionType questionType, long timeout, Kahoot kahoot) {
		super();
		this.question = question;
		this.questionType = questionType;
		this.timeout = timeout;
		this.kahoot = kahoot;
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
	
	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Kahoot getKahoot() {
		return kahoot;
	}

	public void setKahoot(Kahoot kahoot) {
		this.kahoot = kahoot;
	}

	public long getTimeout() {
		return timeout;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", questionType=" + questionType
				+ ", timeout=" + timeout + ", kahoot=" + kahoot + "]";
	}
	
}
