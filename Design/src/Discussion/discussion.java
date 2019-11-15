package Discussion;

import java.sql.Timestamp;
import java.util.Date;

public class discussion {
	
	private String Disno;	//讨论组编号
	private String Disn;	//讨论组名
	private String Uno;		//组长
	private Date Dct;		//创建时间
	private String DBri;	//简介
	public String getDisno() {
		return Disno;
	}
	public void setDisno(String disno) {
		Disno = disno;
	}
	public String getDisn() {
		return Disn;
	}
	public void setDisn(String disn) {
		Disn = disn;
	}
	public String getUno() {
		return Uno;
	}
	public void setUno(String uno) {
		Uno = uno;
	}
	public Date getDct() {
		return Dct;
	}
	public void setDct(Date dct) {
		Dct = dct;
	}
	public String getDBri() {
		return DBri;
	}
	public void setDBri(String dBri) {
		DBri = dBri;
	}
}
