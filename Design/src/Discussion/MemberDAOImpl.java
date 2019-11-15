package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class MemberDAOImpl implements MemberDAO{

	public void InsertMember(Member me) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Member values(?,?)");
		pstm.setString(1, me.getDisno());
		pstm.setString(2, me.getUno());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteMember(String Disno, String Uno) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Member where DISNO=? and UNO=?");
		pstm.setString(1, Disno);
		pstm.setString(2, Uno);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Member> GetMember(String sql) throws Exception {
		List<Member> members=new ArrayList<Member>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Member member=new Member();
			member.setDisno(rs.getString(1));
			member.setUno(rs.getString(2));
			members.add(member);
		}
		return members;
	}

}
