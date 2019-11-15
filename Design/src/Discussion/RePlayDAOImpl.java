package Discussion;

import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class RePlayDAOImpl implements RePlayDAO{

	public void InsertRePlay(RePlay re) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?)");
		pstm.setString(1, re.getRcont());
		pstm.setString(2, re.getReno());
		pstm.setString(3, re.getTono());
		pstm.setString(4, re.getUno());
		pstm.setDate(5, re.getRt());
		pstm.close();
		db.close();
	}

	public void UpdateRePlay(RePlay di) throws Exception {
		
	}

	public void DeleteRePlay(String Reno) throws Exception {
		
	}

	public RePlay getRePlay(String Reno) throws Exception {
		
		return null;
	}

	public List<RePlay> getRePlays(String sql) {
		
		return null;
	}
	

}
