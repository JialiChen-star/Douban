package Discussion;

import java.util.List;

public interface TopicDAO {

	public void InsertTopic(Topic to)throws Exception;
	public void UpdateTopic(Topic to)throws Exception;
	public void DeleteTopic(String Tono)throws Exception;
	public Topic getTopic(String Tono)throws Exception;
	public List<Topic> getTopics(String sql)throws Exception;
}
