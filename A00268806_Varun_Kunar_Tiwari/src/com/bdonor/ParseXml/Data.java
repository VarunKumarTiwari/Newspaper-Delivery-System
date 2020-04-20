package com.bdonor.ParseXml;

public class Data {
	private String name;
    private String author;
    private String price;
    private String ISBN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    @Override
    public String toString() {
        return "[" + this.name + "]" + " by " + this.author + " at " + this.price;
    }
}
