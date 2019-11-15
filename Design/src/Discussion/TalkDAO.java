package Discussion;

import java.util.List;

public interface TalkDAO {
	public void InsertTalk(Talk ta)throws Exception;
	public void DeleteTalk(String disno,String Tono)throws Exception;
	public List<Talk> getTalk(String sql)throws Exception;
}
