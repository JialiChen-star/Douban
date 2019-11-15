package Discussion;

import java.util.List;

public interface DiscussionDAO {
	public void InsertDiscussion(discussion di)throws Exception;
	public void UpdateDiscussion(discussion di)throws Exception;
	public void DeleteDiscussion(String Dno)throws Exception;
	public discussion getDiscussion(String Dno)throws Exception;
	public List<discussion> getDiscussions(String sql)throws Exception;
}
