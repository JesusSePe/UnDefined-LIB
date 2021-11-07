package objects;

public class Topic {
	private long topicId;
	private String topic;
	
	public Topic(String topic) {
		super();
		this.topic = topic;
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
	
	
}
