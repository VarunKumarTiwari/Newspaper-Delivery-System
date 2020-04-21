package com.NDS.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "NDS")
@XmlType(propOrder = { "id","name", "frequecny", "amount", "price"})
public class Data {
	private int id;
	private String name;
	
	private String frequecny;
	private int amount;
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrequecny() {
		return frequecny;
	}
	public void setFrequecny(String frequecny) {
		this.frequecny = frequecny;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", frequecny=" + frequecny + ", amount=" + amount + ", price="
				+ price + "]";
	}
	
	
	
}
