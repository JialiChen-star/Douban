package Discussion;

import java.util.List;

public interface PublishDAO {
	public void InsertPublish(Publish pu)throws Exception;
	public void DeletePublish(String Reno,String Uno)throws Exception;
	public List<Publish> GetPublish(String sql)throws Exception;
}
