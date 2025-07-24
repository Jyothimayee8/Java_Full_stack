package com.bank;

import java.util.Scanner;

public class This_keyword {
	int cno;
	String cname;
	String cadd;
	long cmob;
	
	This_keyword(int cno, String cname, String cadd, long cmob ){
		this.cno= cno;
		this.cname = cname;
		this.cadd = cadd;
		this.cmob = cmob;
	

		 System.out.println("account number  : " + cno);
	     System.out.println("Name       : " + cname);
	     System.out.println("Address      : " + cadd);
	     System.out.println("Mobile : " + cmob);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is the example for the this keyword");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account Number      : ");
        int cno = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name     : ");
        String cname = sc.nextLine();
        
        System.out.print("Enter Address     : ");
        String cadd = sc.nextLine();

        System.out.print("Enter Mobile      : ");
        long cmob = sc.nextLong();
        
        sc.close();
        //object
        
        This_keyword a = new This_keyword(cno,cname,cadd,cmob); 
       
	}

}