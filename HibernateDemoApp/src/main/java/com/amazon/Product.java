//pojo class
package com.amazon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//annotation
@Entity
@Table(name = "product_info") // create table
public class Product {
	@Id    // as primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid") //to change pid for own name
	
	private int pid;
	private String pname;
	private int price;
	
	public Product(int pid, String pname, int price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
}
