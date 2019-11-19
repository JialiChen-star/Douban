package Discussion;

import java.util.Date;

public class RePlay {
	private String Reno;	//回复或评论编号
	private String Tono;	//话题编号
	private String Uno;		//用户编号
	private String Rcont;	//回复或评价内容
	private Date Rt;	//回复/评价时间
	public String getReno() {
		return Reno;
	}
	public void setReno(String reno) {
		Reno = reno;
	}
	public String getTono() {
		return Tono;
	}
	public void setTono(String tono) {
		Tono = tono;
	}
	public String getUno() {
		return Uno;
	}
	public void setUno(String uno) {
		Uno = uno;
	}
	public String getRcont() {
		return Rcont;
	}
	public void setRcont(String rcont) {
		Rcont = rcont;
	}
	public Date getRt() {
		return Rt;
	}
	public void setRt(Date date) {
		Rt = date;
	}
}
