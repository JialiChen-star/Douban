package Discussion;

import java.util.List;

public interface CommentDAO {

	public void InsertComment(Comment co)throws Exception;
	public void DeleteComment(String Reno,String Tono)throws Exception;
	public List<Comment> GetComment(String sql)throws Exception;
}
