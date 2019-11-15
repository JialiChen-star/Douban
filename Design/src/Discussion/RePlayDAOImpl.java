package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class RePlayDAOImpl implements RePlayDAO{

	public void InsertRePlay(RePlay re) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into RePlay values(?,?,?,?,?)");
		pstm.setString(2, re.getReno());
		pstm.setString(3, re.getTono());
		pstm.setString(4, re.getUno());
		pstm.setString(1, re.getRcont());
		pstm.setDate(5, re.getRt());
		pstm.close();
		db.close();
	}

	public void UpdateRePlay(RePlay re) throws Exception {
		String Re=re.getReno();
		DeleteRePlay(Re);
		InsertRePlay(re);
	}

	public void DeleteRePlay(String Reno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form RePlay where RENO=?");
		pstm.setString(1, Reno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public RePlay getRePlay(String Reno) throws Exception {
		RePlay replay=new RePlay();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from RePlay where RENO=?");
		pstm.setString(1, Reno);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			replay.setReno(rs.getString(1));
			replay.setTono(rs.getString(2));
			replay.setUno(rs.getString(3));
			replay.setRt(rs.getDate(4));
			replay.setRcont(rs.getString(5));
		}
		rs.close();
		db.close();
		pstm.close();
		return replay;
	}

	public List<RePlay> getRePlays(String sql) throws Exception{
		List<RePlay> replays=new ArrayList<RePlay>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			RePlay replay=new RePlay();
			replay.setReno(rs.getString(1));
			replay.setTono(rs.getString(2));
			replay.setUno(rs.getString(3));
			replay.setRt(rs.getDate(4));
			replay.setRcont(rs.getString(5));
			replays.add(replay);
		}
		rs.close();
		pstm.close();
		db.close();
		return null;
	}
	
}
