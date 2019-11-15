package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class DirectDAOImpl implements DirectDAO{

	public void InsertDirect(Direct di) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Direct values(?,?)");
		pstm.setString(1, di.getMno());
		pstm.setString(2, di.getDno());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteDirect(String Mno,String Dno) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Direct where MNO=? and DNO=?");
		pstm.setString(1, Mno);
		pstm.setString(2, Dno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Direct> GetDirect(String sql) throws Exception {
		List<Direct> directs=new ArrayList<Direct>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Direct direct=new Direct();
			direct.setMno(rs.getString(1));
			direct.setDno(rs.getString(2));
			directs.add(direct);
		}
		rs.close();
		pstm.close();
		db.close();
		return directs;
	}
	

}
