package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
		String ano=pl.getAno();
		String mno=pl.getMno();
		DeletePlay(ano,mno);
		InsertPlay(pl);
	}

	public void DeletePlay(String Ano,String Mno) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Movies where ANO=? and MNO=?");
		pstm.setString(1, Ano);
		pstm.setString(1, Mno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public Play getPlay(String Ano,String Mno) throws Exception {
		Play play=new Play();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Play where ANO=? and MNO=?");
		pstm.setString(1, Ano);
		pstm.setString(2, Mno);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			play.setAno(rs.getString(1));
			play.setMno(rs.getString(2));
			play.setPro(rs.getString(3));
			play.setPn(rs.getString(4));
		}
		db.close();
		rs.close();
		pstm.close();
		return play;
	}

	public List<Play> getPlays(String sql) throws Exception{
		List<Play> plays=new ArrayList<Play>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Play play=new Play();
			play.setAno(rs.getString(1));
			play.setMno(rs.getString(2));
			play.setPro(rs.getString(4));
			play.setPn(rs.getString(3));
			plays.add(play);
		}
		rs.close();
		pstm.close();
		db.close();
		return plays;
	}

}
