package Discussion;

import java.sql.Timestamp;
import java.util.Date;

public class discussion {
	
	private String Disno;	//��������
	private String Disn;	//��������
	private String Uno;		//�鳤
	private Date Dct;		//����ʱ��
	private String DBri;	//���
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
