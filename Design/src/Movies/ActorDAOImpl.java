package Movies;

import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class ActorDAOImpl implements ActorDAO{

	public void InsertActor(Actor ac) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?,?,?)");
		pstm.setString(1, ac.getAno());
		pstm.setString(2, ac.getAn());
		pstm.setString(3, ac.getAsex());
		pstm.setString(4, ac.getAcon());
		pstm.setString(6, ac.getApic());
		pstm.setString(5, ac.getAbri());
		pstm.setString(7, ac.getABrith());
		pstm.close();
		db.close();
		
	}

	public void UpdateActor(Actor ac) throws Exception {
	
		
	}

	public void DeleteActor(String Ano) throws Exception {
		
		
	}

	public Actor getActor(String Ano) throws Exception {
		
		return null;
	}

	public List<Actor> getActors(String sql) throws Exception{
		
		return null;
	}

}
