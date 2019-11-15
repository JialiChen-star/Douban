package Discussion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class TopicDAOImpl implements TopicDAO{

	public void InsertTopic(Topic to) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?)");
		pstm.setString(1, to.getTono());
		pstm.setString(2, to.getTon());
		pstm.setString(3, to.getUno());
		pstm.setString(4, to.getCont());
		pstm.setDate(5, (Date) to.getTot());
		pstm.close();
		db.close();
	}

	public void UpdateTopic(Topic to) throws Exception {
	
		
	}

	public void DeleteTopic(String Tono) throws Exception {
		
		
	}

	public Topic getTopic(String Tono) throws Exception {
		
		return null;
	}

	public List<Topic> getTopics(String sql) {
	
		return null;
	}

}
