package Discussion;

import java.util.List;

public interface InitTopicDAO {
	public void InsertInitTopic(InitTopic in)throws Exception;
	public void deleteInitTopic(String Tono,String Uno)throws Exception;
	public List<InitTopic> GetInitTopic(String sql)throws Exception;
}
