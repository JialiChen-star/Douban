package Movies;

import java.util.List;

public interface ActorDAO {

	public void InsertActor( Actor ac)throws Exception;
	public void UpdateActor( Actor ac)throws Exception;
	public void DeleteActor(String Ano)throws Exception;
	public  Actor getActor(String Ano)throws Exception;
	public List< Actor> getActors(String sql)throws Exception;
}
