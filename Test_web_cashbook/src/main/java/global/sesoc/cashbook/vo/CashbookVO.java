package global.sesoc.cashbook.vo;

//가계부 내역 정보
public class CashbookVO {

	private String infonum;
	private String userid;
	private String type;
	private String memo;
	private int amount;
	private String inputdate;
	
	public CashbookVO() {}
	
	public CashbookVO(String infonum, String userid, String memo, String type, int amount, String inputdate) {
		super();
		this.infonum = infonum;
		this.userid = userid;
		this.memo = memo;
		this.type = type;
		this.amount = amount;
		this.inputdate = inputdate;
	}
	
	public String getInfonum() {
		return infonum;
	}
	public void setInfonum(String infonum) {
		this.infonum = infonum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
	@Override
	public String toString() {
		return "MoneybookVO [infonum=" + infonum + ", userid=" + userid + ", memo=" + memo + ", type=" + type
				+ ", amount=" + amount + ", inputdate=" + inputdate + "]";
	}
}
