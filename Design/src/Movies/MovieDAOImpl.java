package Movies;
import DateBaseConnection.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class MovieDAOImpl implements MovieDAO{

	public void InsertMovie(Movie mo) throws Exception {
	
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, mo.getMno());
		pstm.setString(2, mo.getMn());
		pstm.setString(3, mo.getMmn());
		pstm.setString(4, mo.getMt());
		pstm.setString(5, mo.getMl());
		pstm.setDate(6, (Date) mo.getUd());
		pstm.setString(7, mo.getACon());
		pstm.setString(8, mo.getTL());
		pstm.setString(9, mo.getBri());
		pstm.setString(10, mo.getPic());	
		pstm.close();
		db.close();
	}

	public void UpdateMovie(Movie mo) throws Exception {
		
	}

	public void DeleteMovie(String Mno) throws Exception {

	}

	public Movie getMovie(String Mno) {
		return null;
	}

	public List<Movie> GetMovies(String sql) throws Exception{
		
		return null;
	}

	
	
}
