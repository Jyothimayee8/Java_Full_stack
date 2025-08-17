//pojo class
package com.library;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books_Info") // create table
public class Book{
		@Id    // as primary key
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "bookid") //to change bid for own name
		
	private int bid;
	private String bname;
	private int price;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	public Book(int bid, String bname, int price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}