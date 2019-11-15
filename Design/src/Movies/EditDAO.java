package Movies;

import java.util.List;

public interface EditDAO {
	
	public void InsertEdit(Edit ed)throws Exception;
	public void DeleteEdit(String Mno,String Eno)throws Exception;
	public List<Edit> getEdit(String sql)throws Exception;
	
}
