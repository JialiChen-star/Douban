package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class InitTopicDAOImpl implements InitTopicDAO{

	public void InsertInitTopic(InitTopic in) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into InitTopic values(?,?)");
		pstm.setString(1, in.getTono());
		pstm.setString(2, in.getUno());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void deleteInitTopic(String Tono, String Uno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from InitTopic where TONO=? and UNO=?");
		pstm.setString(1, Tono);
		pstm.setString(2, Uno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<InitTopic> GetInitTopic(String sql) throws Exception{
		List<InitTopic> inittopics=new ArrayList<InitTopic>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			InitTopic inittopic=new InitTopic();
			inittopic.setTono(rs.getString(1));
			inittopic.setUno(rs.getString(2));
			inittopics.add(inittopic);
		}
		rs.close();
		pstm.close();
		db.close();
		return inittopics;
	}

}
