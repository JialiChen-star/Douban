package Movies;

import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class DirectorDAOImpl implements DirectorDAO{

	public void InsertDirector(Director dir) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?,?,?)");
		pstm.setString(1, dir.getDno());
		pstm.setString(2, dir.getDn());
		pstm.setString(3, dir.getDsex());
		pstm.setString(4, dir.getDcon());
		pstm.setString(5, dir.getDpic());
		pstm.setString(6, dir.getDbri());
		pstm.setString(7, dir.getDBrith());
		pstm.close();
		db.close();	
	}

	public void UpdateDirector(Director dir) throws Exception {
		
	}

	public void DeleteDirector(String Dno) throws Exception {
		
	}

	public Director getDirector(String Dno) throws Exception {
		
		return null;
	}

	public List<Director> getDirectors(String sql) throws Exception{
		
		return null;
	}

}
