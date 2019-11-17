package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class DirectorDAOImpl implements DirectorDAO{

	public void InsertDirector(Director dir) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Directors values(?,?,?,?,?,?,?)");
		pstm.setString(1, dir.getDno());
		pstm.setString(2, dir.getDn());
		pstm.setString(3, dir.getDsex());
		pstm.setString(4, dir.getDcon());
		pstm.setString(5, dir.getDbri());
		pstm.setString(6, dir.getDpic());
		pstm.setString(7, dir.getDBrith());
		pstm.executeUpdate();
		pstm.close();
		db.close();	
	}

	public void UpdateDirector(Director dir) throws Exception {
		String Dno=dir.getDno();
		DeleteDirector(Dno);
		InsertDirector(dir);
	}

	public void DeleteDirector(String Dno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Directors where DNO=?");
		pstm.setString(1, Dno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public Director getDirector(String Dno) throws Exception {
		Director director=new Director();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from Directors where DNO=?");
		pstm.setString(1, Dno);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			director.setDno(rs.getString(1));
			director.setDn(rs.getString(2));
			director.setDsex(rs.getString(3));
			director.setDcon(rs.getString(4));
			director.setDbri(rs.getString(5));
			director.setDpic(rs.getString(6));
			director.setDBrith(rs.getString(7));
		}
		rs.close();
		pstm.close();
		db.close();
		return director;
	}

	public List<Director> getDirectors(String sql) throws Exception{
		
		List<Director> directors=new ArrayList<Director>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Director director=new Director();
			director.setDno(rs.getString(1));
			director.setDn(rs.getString(2));
			director.setDsex(rs.getString(3));
			director.setDcon(rs.getString(4));
			director.setDbri(rs.getString(5));
			director.setDpic(rs.getString(6));
			director.setDBrith(rs.getString(7));
			directors.add(director);
		}
		return directors;
	}

}
