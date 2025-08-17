package com.io;

import java.io.Serializable;

// pojo class
public class Employee implements Serializable {

	private int eid;
	private String ename;
	private long mobno;
	
	//constructor 
	
	public Employee(int eid, String ename, long mobno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.mobno = mobno;
	}
	
	
	// methods 
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public long getMobno() {
		return mobno;
	}



	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", mobno=" + mobno + "]";
	}

}
