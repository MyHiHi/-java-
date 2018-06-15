package gmc.entity;

public class Manufacture {
	private Integer manuId;
	private Integer userId;

	private String enName;
	private String cnName;
	private String status;
	private String certiType;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getManuId() {
		return manuId;
	}
	public void setManuId(Integer manuId) {
		this.manuId = manuId;
	}

	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}


	
}
