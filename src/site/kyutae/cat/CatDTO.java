package site.kyutae.cat;

public class CatDTO {
	private int cnum;
	private String cname,ckind,cage,cgender,cbirth;
	public CatDTO() {
		// TODO Auto-generated constructor stub
	}
	public CatDTO(int cnum, String cname, String ckind, String cage, String cgender, String cbirth) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.ckind = ckind;
		this.cage = cage;
		this.cgender = cgender;
		this.cbirth = cbirth;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCkind() {
		return ckind;
	}
	public void setCkind(String ckind) {
		this.ckind = ckind;
	}
	public String getCage() {
		return cage;
	}
	public void setCage(String cage) {
		this.cage = cage;
	}
	public String getCgender() {
		return cgender;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public String getCbirth() {
		return cbirth;
	}
	public void setCbirth(String cbirth) {
		this.cbirth = cbirth;
	}
	
}
