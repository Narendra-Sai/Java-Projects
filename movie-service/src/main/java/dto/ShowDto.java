package dto;

public class ShowDto {

	private long id;
	private String sTime;
	private String eTime;
	private String price;
	private String showTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	@Override
	public String toString() {
		return "ShowDto [id=" + id + ", sTime=" + sTime + ", eTime=" + eTime + ", price=" + price + ", showTime="
				+ showTime + "]";
	}
	
	
	
}
