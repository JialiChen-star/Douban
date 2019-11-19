package Movies;
import DateBaseConnection.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDAOImpl implements MovieDAO{

	public void InsertMovie(Movie mo) throws Exception {
	
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Movie values(?,?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, mo.getMno());
		pstm.setString(2, mo.getMn());
		pstm.setString(3, mo.getMmn());
		pstm.setString(4, mo.getMt());
		pstm.setString(5, mo.getMl());
		pstm.setString(6, mo.getUd());
		pstm.setString(7, mo.getACon());
		pstm.setString(8, mo.getTL());
		pstm.setString(9, mo.getBri());
		pstm.setString(10, mo.getPic());	
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteMovie(String Mno) throws Exception {

		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Movies where MNO=?");
		pstm.setString(1, Mno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}
	
	public void UpdateMovie(Movie mo) throws Exception {	//插入修改后的数据
		
		String Mno=mo.getMmn();
		DeleteMovie(Mno);
		InsertMovie(mo);
	}

	public Movie getMovie(String Mno) throws Exception{
		
		Movie movie=new Movie();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from Movie where MNO=?");
		pstm.setString(1, Mno);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			movie.setMno(rs.getString(1));
			movie.setMn(rs.getString(2));
			movie.setMmn(rs.getString(3));
			movie.setMt(rs.getString(4));
			movie.setMl(rs.getString(5));
			movie.setUd(rs.getString(6));
			movie.setACon(rs.getString(7));
			movie.setTL(rs.getString(8));
			movie.setBri(rs.getString(9));
			movie.setPic(rs.getString(10));
			
		}
		rs.close();
		pstm.close();
		db.close();
		return movie;
	}

	public List<Movie> GetMovies(String sql) throws Exception{
		Scanner in=new Scanner(System.in);
		List<Movie> movies=new ArrayList<Movie>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		String type=in.next();
		pstm.setString(1, type);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Movie movie=new Movie();
			movie.setMno(rs.getString(1));
			movie.setMn(rs.getString(2));
			movie.setMmn(rs.getString(3));
			movie.setMt(rs.getString(4));
			movie.setMl(rs.getString(5));
			movie.setUd(rs.getString(6));
			movie.setACon(rs.getString(7));
			movie.setTL(rs.getString(8));
			movie.setBri(rs.getString(9));
			movie.setPic(rs.getString(10));	
			movies.add(movie);
		}
		rs.close();
		pstm.close();
		db.close();
		in.close();
		return movies;
	}
}
