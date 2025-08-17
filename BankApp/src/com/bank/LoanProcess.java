package com.bank;

public class LoanProcess {
	public void Loan(int loanamt, int gst, int pfee) {
		System.out.println("Personnel loan amount:"+(loanamt-gst-pfee));
		
	}
	public void Loan(int loanamt, int pfee) {
		System.out.println("Home loan amout is:"+(loanamt-pfee));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoanProcess lp = new LoanProcess();
		lp.Loan(500000,2000, 3000);
		lp.Loan(500000, 30000);
	}

}

