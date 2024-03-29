package DateBaseConnection;
//该类为数据库连接类，其中包括新建连接对象，获取连接对象，关闭连接对象
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseconnection {
	private String Dbdriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String Dburl="jdbc:sqlserver://localhost;databaseName=MOVIES;user=stu;password=123";//?useUnicode=true&characterEncoding=utf-8
	private Connection conn=null;
	public DateBaseconnection() {
		try {
			Class.forName(Dbdriver);
			conn=DriverManager.getConnection(Dburl);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
