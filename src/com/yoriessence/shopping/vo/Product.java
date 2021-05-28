package com.yoriessence.shopping.vo;

public class Product {
	
	private int productNo;
	private int stock;
	private int price;
	private String explanation;
	private String productName;
	private String productImage;
	private String productkategorie;
	private int productshopify;
	
	

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productNo, int stock, int price, String explanation, String productName,
			String productImage, String productkategorie, int productshopify) {
		super();
		this.productNo = productNo;
		this.stock = stock;
		this.price = price;
		this.explanation = explanation;
		this.productName = productName;
		this.productImage = productImage;
		this.productkategorie = productkategorie;
		this.productshopify = productshopify;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductkategorie() {
		return productkategorie;
	}

	public void setProductkategorie(String productkategorie) {
		this.productkategorie = productkategorie;
	}

	public int getProductshopify() {
		return productshopify;
	}

	public void setProductshopify(int productshopify) {
		this.productshopify = productshopify;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((explanation == null) ? 0 : explanation.hashCode());
		result = prime * result + price;
		result = prime * result + ((productImage == null) ? 0 : productImage.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNo;
		result = prime * result + ((productkategorie == null) ? 0 : productkategorie.hashCode());
		result = prime * result + productshopify;
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (explanation == null) {
			if (other.explanation != null)
				return false;
		} else if (!explanation.equals(other.explanation))
			return false;
		if (price != other.price)
			return false;
		if (productImage == null) {
			if (other.productImage != null)
				return false;
		} else if (!productImage.equals(other.productImage))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productNo != other.productNo)
			return false;
		if (productkategorie == null) {
			if (other.productkategorie != null)
				return false;
		} else if (!productkategorie.equals(other.productkategorie))
			return false;
		if (productshopify != other.productshopify)
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	
	
}
