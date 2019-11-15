package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	
		String Ano=ac.getAno();
		DeleteActor(Ano);
		InsertActor(ac);
	}

	public void DeleteActor(String Ano) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Movies where ANO=?");
		pstm.setString(1, Ano);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public Actor getActor(String Ano) throws Exception {
		
		Actor actor=new Actor();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from Actor where ANO=?");
		pstm.setString(1, Ano);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			actor.setAno(rs.getString(1));
			actor.setAn(rs.getString(2));
			actor.setAsex(rs.getString(3));
			actor.setAcon(rs.getString(4));
			actor.setApic(rs.getString(7));
			actor.setAbri(rs.getString(6));
			actor.setABrith(rs.getString(5));
		}
		rs.close();
		pstm.close();
		db.close();
		return actor;
	}

	public List<Actor> getActors(String sql) throws Exception{
		
		List<Actor> actors=new ArrayList<Actor>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Actor actor=new Actor();
			actor.setAno(rs.getString(1));
			actor.setAn(rs.getString(2));
			actor.setAsex(rs.getString(3));
			actor.setAcon(rs.getString(4));
			actor.setApic(rs.getString(5));
			actor.setAbri(rs.getString(6));
			actor.setABrith(rs.getString(7));
			actors.add(actor);
		}
		db.close();
		pstm.close();
		rs.close();
		return actors;
	}

}
