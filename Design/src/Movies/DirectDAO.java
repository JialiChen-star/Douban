package Movies;

import java.beans.Expression;
import java.util.List;

public interface DirectDAO {

	public void InsertDirect(Direct di)throws Exception;
	public void DeleteDirect(String Mno,String Dno)throws Exception;
	public List<Direct> GetDirect(String sql)throws Exception;
}
