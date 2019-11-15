package Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DateBaseConnection.DateBaseconnection;

public class CommentDAOImpl implements CommentDAO{

	public void InsertComment(Comment co) throws Exception {
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("insert into Comment values(?,?)");
		pstm.setString(1, co.getReno());
		pstm.setString(2, co.getTono());
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public void DeleteComment(String Reno, String Tono) throws Exception {
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("delete from Comment where RENO=? and TONO=?");
		pstm.setString(1, Reno);
		pstm.setString(2, Tono);
		pstm.executeUpdate();
		pstm.close();
		db.close();
	}

	public List<Comment> GetComment(String sql) throws Exception {
		List<Comment> comments=new ArrayList<Comment>();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		pstm.executeUpdate();
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Comment comment=new Comment();
			comment.setReno(rs.getString(1));
			comment.setTono(rs.getString(2));
			comments.add(comment);
		}
		rs.close();
		pstm.close();
		db.close();
		return comments;
	}

}
