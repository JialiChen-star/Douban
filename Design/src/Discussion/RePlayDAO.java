package Discussion;

import java.util.List;

public interface RePlayDAO {

	public void InsertRePlay(RePlay re)throws Exception;
	public void UpdateRePlay(RePlay re)throws Exception;
	public void DeleteRePlay(String Reno)throws Exception;
	public RePlay getRePlay(String Reno)throws Exception;
	public List<RePlay> getRePlays(String sql)throws Exception;
}
