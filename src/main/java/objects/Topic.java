package objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private long topicId;
	
	@Column(name = "topic")
	private String topic;
	
	@OneToMany(mappedBy = "topic", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<Kahoot> kahoots;
	

	public Topic() {
		super();
	}

	public Topic(String topic, List<Kahoot> kahoots) {
		super();
		this.topic = topic;
		this.kahoots = kahoots;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Kahoot> getKahoots() {
		return kahoots;
	}

	public void setKahoots(List<Kahoot> kahoots) {
		this.kahoots = kahoots;
	}
	
	
}
