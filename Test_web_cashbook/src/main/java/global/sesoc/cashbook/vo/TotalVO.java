package global.sesoc.cashbook.vo;

//연도별 통계 정보
public class TotalVO {
	int year;			//연도
	int totalIn;		//수입 합계
	int totalOut;		//지출 합계
	
	public TotalVO() {
	}
	
	public TotalVO(int year, int totalIn, int totalOut) {
		this.year = year;
		this.totalIn = totalIn;
		this.totalOut = totalOut;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTotalIn() {
		return totalIn;
	}
	public void setTotalIn(int totalIn) {
		this.totalIn = totalIn;
	}
	public int getTotalOut() {
		return totalOut;
	}
	public void setTotalOut(int totalOut) {
		this.totalOut = totalOut;
	}
	
	@Override
	public String toString() {
		return "TotalVO [year=" + year + ", totalIn=" + totalIn + ", totalOut=" + totalOut + "]";
	}
}
