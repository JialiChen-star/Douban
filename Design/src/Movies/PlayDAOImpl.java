package Movies;

import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class PlayDAOImpl implements PlayDAO{

	public void InsertPlay(Play pl) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?)");
		pstm.setString(1, pl.getAno());
		pstm.setString(2, pl.getMno());
		pstm.setString(3, pl.getPro());
		pstm.setString(4, pl.getPn());
		pstm.close();
		db.close();
	}

	public void UpdatePlay(Play pl) throws Exception {
		
	}

	public void DeletePlay(String Pno) throws Exception {
		
	}

	public Play getPlay(String Pno) throws Exception {
		
		return null;
	}

	public List<Play> getPlays(String sql) throws Exception{
		
		return null;
	}

}
