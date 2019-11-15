package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class PublishDAOImpl implements PublishDAO{

	public void InsertPublish(Publish pu) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Publish values(?,?)");
		pstm.setString(1, pu.getReno());
		pstm.setString(2, pu.getUno());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeletePublish(String Reno, String Uno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Publish where RENO=? and UNO=?");
		pstm.setString(1, Reno);
		pstm.setString(2, Uno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Publish> GetPublish(String sql) throws Exception {
		List<Publish> publishs=new ArrayList<Publish>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Publish publish=new Publish();
			publish.setReno(rs.getString(1));
			publish.setUno(rs.getString(2));
			publishs.add(publish);
		}
		rs.close();
		pstm.close();
		db.close();
		return publishs;
	}

}
