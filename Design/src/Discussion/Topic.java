package Discussion;

import java.util.Date;

public class Topic {

	private String Tono;	//话题编号
	private String Ton;		//话题名
	private String Uno;		//用户编码
	private String Cont;	//话题内容
	private Date Tot;	//话题创建时间
	public String getTono() {
		return Tono;
	}
	public void setTono(String tono) {
		Tono = tono;
	}
	public String getTon() {
		return Ton;
	}
	public void setTon(String ton) {
		Ton = ton;
	}
	public String getUno() {
		return Uno;
	}
	public void setUno(String uno) {
		Uno = uno;
	}
	public String getCont() {
		return Cont;
	}
	public void setCont(String cont) {
		Cont = cont;
	}
	public Date getTot() {
		return Tot;
	}
	public void setTot(Date tot) {
		Tot = tot;
	}
	
}
