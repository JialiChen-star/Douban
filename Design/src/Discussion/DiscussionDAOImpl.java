package Discussion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class DiscussionDAOImpl implements DiscussionDAO{

	public void InsertDiscussion(discussion di) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?,)");
		pstm.setString(1, di.getDisno());
		pstm.setString(2, di.getUno());
		pstm.setString(3, di.getDBri());
		pstm.setDate(4, (Date) di.getDct());
		pstm.setString(5, di.getDisn());
		db.close();
	}

	public void UpdateDiscussion(discussion di) throws Exception {
		
	}

	public void DeleteDiscussion(String Dno) throws Exception {
	
	}

	public discussion getDiscussion(String Dno) throws Exception {

		return null;
	}

	public List<discussion> getDiscussions(String sql) {
		
		return null;
	}

	
}
