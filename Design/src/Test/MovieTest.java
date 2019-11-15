package Test;
import java.sql.PreparedStatement;
import java.util.Scanner;
import DAO.*;
import DateBaseConnection.DateBaseconnection;
import Movies.*;
public class MovieTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		MovieDAOFactory.getMoivesDAO();
		in.close();
	}
	public static void Sereach(String sql) throws Exception{
		
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement(sql);
		
	}

}
