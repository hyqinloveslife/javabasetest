package com.hyqin.java.base;

import java.util.Date;

public class Phone {
	private String name;
	private String type;
	private String size;
	private double price;
	private Date genDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getGenDate() {
		return genDate;
	}
	public void setGenDate(Date genDate) {
		this.genDate = genDate;
	}
	public Phone(String name, String type, String size, double price, Date genDate) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.price = price;
		this.genDate = genDate;
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", type=" + type + ", size=" + size + ", price=" + price + ", genDate=" + genDate
				+ "]";
	}
	public Phone() {
		super();
	}
	
}
