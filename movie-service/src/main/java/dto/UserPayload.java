package dto;

public class UserPayload {

	private long requestId;
	private String requestType;
	private String userid;
	
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserPayload [requestId=" + requestId + ", requestType=" + requestType + ", userid=" + userid + "]";
	}
	
	
}
