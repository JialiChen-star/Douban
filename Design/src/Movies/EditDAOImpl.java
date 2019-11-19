package Movies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class EditDAOImpl implements EditDAO{

	public void InsertEdit(Edit ed) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Edit values(?,?)");
		pstm.setString(1, ed.getMno());
		pstm.setString(2, ed.getEno());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteEdit(String Mno, String Eno) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Edit where MNO=? and ENO=?");
		pstm.setString(1, Mno);
		pstm.setString(2, Eno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Edit> getEdit(String sql) throws Exception {
		List<Edit> edits=new ArrayList<Edit>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Edit edit=new Edit();
			edit.setMno(rs.getString(1));
			edit.setEno(rs.getString(2));
			edits.add(edit);
		}
		return edits;
	}

}
