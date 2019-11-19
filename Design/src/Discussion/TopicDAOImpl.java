package Discussion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class TopicDAOImpl implements TopicDAO{

	public void InsertTopic(Topic to) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Topic values(?,?,?,?,?)");
		pstm.setString(1, to.getTono());
		pstm.setString(2, to.getTon());
		pstm.setString(3, to.getUno());
		pstm.setString(4, to.getCont());
		pstm.setDate(5, (Date) to.getTot());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void UpdateTopic(Topic to) throws Exception {
		String Tono=to.getTono();
		DeleteTopic(Tono);
		InsertTopic(to);	
	}

	public void DeleteTopic(String Tono) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Topic where TONO=?");
		pstm.setString(1, Tono);
		pstm.executeUpdate();
		pstm.close();
		db.close();	
	}

	public Topic getTopic(String Tono) throws Exception {
		Topic topic=new Topic();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Topic where TONO=?");
		pstm.setString(1, Tono);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			topic.setTono(rs.getString(1));
			topic.setTon(rs.getString(2));
			topic.setUno(rs.getString(3));
			topic.setCont(rs.getString(4));
			topic.setTot(rs.getDate(5));
		}
		return null;
	}

	public List<Topic> getTopics(String sql) throws Exception{
	
		List<Topic> topics=new ArrayList<Topic>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Topic topic=new Topic();
			topic.setTono(rs.getString(1));
			topic.setTon(rs.getString(2));
			topic.setUno(rs.getString(3));
			topic.setCont(rs.getString(4));
			topic.setTot(rs.getDate(5));
			topics.add(topic);
		}
		rs.close();
		pstm.close();
		db.close();
		return null;
	}

}
