package com.test.product;

public class ProductVO {

	private String pId;
	private String pName;
	private int originPrice;
	private int salePrice;
	private String pContent;
	private String pImage;
	private double review;

	public ProductVO(String pId, String pName, int originPrice, int salePrice, String pContent, String pImage,
			double review) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.originPrice = originPrice;
		this.salePrice = salePrice;
		this.pContent = pContent;
		this.pImage = pImage;
		this.review = review;
	}

	public ProductVO() {
	
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ProductVO [pId=" + pId + ", pName=" + pName + ", originPrice=" + originPrice + ", salePrice="
				+ salePrice + ", pContent=" + pContent + ", pImage=" + pImage + ", review=" + review + "]";
	}
	
	
}
