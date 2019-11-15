package Movies;

import java.sql.PreparedStatement;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class EtcDAOImpl implements EtcDAO{

	public void InsertEtc(Etc et) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into S values(?,?,?,?,?,?,?)");
		pstm.setString(1, et.getEno());
		pstm.setString(2, et.getEn());
		pstm.setString(3, et.getEsex());
		pstm.setString(4, et.getEcon());
		pstm.setString(5, et.getEpic());
		pstm.setString(6, et.getEbri());
		pstm.setString(7, et.getEBrith());
		pstm.close();
		db.close();
	}

	public void UpdateEtc(Etc et) throws Exception {
		
	}

	public void DeleteEtc(String Eno) throws Exception {
		
	}

	public Etc getEtc(String Eno) throws Exception {
		
		return null;
	}

	public List<Etc> getEtcs(String sql) throws Exception{
		
		return null;
	}

}
