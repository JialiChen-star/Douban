package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class TalkDAOImpl implements TalkDAO{

	public void InsertTalk(Talk ta) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Talk values(?,?)");
		pstm.setString(1, ta.getDisno());
		pstm.setString(2, ta.getTono());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteTalk(String disno, String Tono) throws Exception {
	
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Talk where DISNO=? and TONO=?");
		pstm.setString(1, disno);
		pstm.setString(2, Tono);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Talk> getTalk(String sql) throws Exception {
		List<Talk> talks=new ArrayList<Talk>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Talk talk=new Talk();
			talk.setDisno(rs.getString(1));
			talk.setTono(rs.getString(2));
			talks.add(talk);
		}
		rs.close();
		pstm.close();
		db.close();
		return talks;
	}

}
