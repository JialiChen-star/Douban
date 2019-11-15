package Movies;

import java.util.List;

public interface DirectorDAO {

	public void InsertDirector( Director dir)throws Exception;
	public void UpdateDirector( Director dir)throws Exception;
	public void DeleteDirector(String Dno)throws Exception;
	public  Director getDirector(String Dno)throws Exception;
	public List< Director> getDirectors(String sql)throws Exception;
}
