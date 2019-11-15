package Movies;

import java.util.List;

public interface PlayDAO {

	public void InsertPlay(Play pl)throws Exception;
	public void UpdatePlay(Play pl)throws Exception;
	public void DeletePlay(String Pno)throws Exception;
	public  Play getPlay(String Pno)throws Exception;
	public List<Play> getPlays(String sql)throws Exception;
}
