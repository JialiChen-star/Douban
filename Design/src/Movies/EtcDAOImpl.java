package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class EtcDAOImpl implements EtcDAO{

	public void InsertEtc(Etc et) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		db.getConnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Etc values(?,?,?,?,?,?,?)");
		pstm.setString(1, et.getEno());
		pstm.setString(2, et.getEn());
		pstm.setString(3, et.getEsex());
		pstm.setString(4, et.getEcon());
		pstm.setString(5, et.getEpic());
		pstm.setString(6, et.getEbri());
		pstm.setString(7, et.getEBrith());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void UpdateEtc(Etc et) throws Exception {
		String Eno=et.getEno();
		DeleteEtc(Eno);
		InsertEtc(et);
	}

	public void DeleteEtc(String Eno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete form Etc where ENO=?");
		pstm.setString(1, Eno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public Etc getEtc(String Eno) throws Exception {
		Etc etc=new Etc();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("selete * from Etc where ENO=?");
		pstm.setString(1, Eno);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			etc.setEno(rs.getString(1));
			etc.setEn(rs.getString(2));
			etc.setEsex(rs.getString(3));
			etc.setEcon(rs.getString(4));
			etc.setEpic(rs.getString(5));
			etc.setEbri(rs.getString(6));
			etc.setEBrith(rs.getString(7));
		}
		pstm.close();
		rs.close();
		db.close();
		return etc;
	}

	public List<Etc> getEtcs(String sql) throws Exception{
		List<Etc> etcs=new ArrayList<Etc>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Etc etc=new Etc();
			etc.setEno(rs.getString(1));
			etc.setEn(rs.getString(2));
			etc.setEsex(rs.getString(3));
			etc.setEcon(rs.getString(4));
			etc.setEpic(rs.getString(5));
			etc.setEbri(rs.getString(6));
			etc.setEBrith(rs.getString(7));
			etcs.add(etc);
			
		}
		return etcs;
	}

}
