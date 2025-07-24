package com.bank;

public class Loan extends Customer{
	int lid;
	double loanamt;
	String loantype;
    
	// constructor
	Loan(int lid, double loanamt, String loantype, int cid, String cname, String address, long mobilenumber){
		super.setCustomerDetails(cid, cname, address, mobilenumber);
		this.lid = lid;
		this.loanamt  = loanamt;
		this.loantype = loantype;
	}
	void getdetails() {
		System.out.println("Loan id : "+lid);
		System.out.println("loan amount : "+loanamt);
		System.out.println("loan type: "+loantype);
	}
	public static void main(String[] args) {
		Loan l = new Loan(101111,2344344,"personal loan",11111,"jyo","ong",543436676);
		l.getCustomerDetails();
		l.getdetails();
	}

}
