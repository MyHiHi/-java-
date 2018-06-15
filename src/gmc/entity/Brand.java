package gmc.entity;

public class Brand {
	private Integer brandId;
	private Integer manuId;
	private String enName;
	private String cnName;
	private String logo;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}



}
