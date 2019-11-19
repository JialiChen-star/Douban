package Discussion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class DiscussionDAOImpl implements DiscussionDAO{

	public void InsertDiscussion(discussion di) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Discussion values(?,?,?,?,?,)");
		pstm.setString(1, di.getDisno());
		pstm.setString(2, di.getUno());
		pstm.setString(3, di.getDBri());
		pstm.setDate(4, (Date) di.getDct());
		pstm.setString(5, di.getDisn());
		pstm.executeUpdate();
		db.close();
	}

	public void UpdateDiscussion(discussion di) throws Exception {
		String Disno=di.getDisno();
		DeleteDiscussion(Disno);
		InsertDiscussion(di);
	}

	public void DeleteDiscussion(String Disno) throws Exception {
	
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Discussion where DISNO=?");
		pstm.setString(1, Disno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public discussion getDiscussion(String Disno) throws Exception {
		discussion discus=new discussion();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from Discussion where DISNO=?");
		pstm.setString(1, Disno);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			discus.setDisno(rs.getString(1));
			discus.setUno(rs.getString(2));
			discus.setDBri(rs.getString(2));
			discus.setDct(rs.getDate(4));
			discus.setDisn(rs.getString(5));
		}
		rs.close();
		pstm.close();
		db.close();
		return discus;
	}

	public List<discussion> getDiscussions(String sql) throws Exception{
		List<discussion> discuss=new ArrayList<discussion>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			discussion discus=new discussion();
			discus.setDisno(rs.getString(1));
			discus.setUno(rs.getString(2));
			discus.setDBri(rs.getString(2));
			discus.setDct(rs.getDate(4));
			discus.setDisn(rs.getString(5));
			discuss.add(discus);
		}
		rs.close();
		pstm.close();
		db.close();
		return discuss;
	}

	
}
