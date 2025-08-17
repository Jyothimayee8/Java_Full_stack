// user defined or customized exception
package com.exception;

class GreaterMarksException extends RuntimeException{
	
}

class Student{
	// fields
	 int rollno;
	 String name;
	 int marks;
	// constructor 
	 public Student(int rollno, String name, int marks) {
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	 }
	 
	 // Business Logic
	 void insert() {
		 if(marks>100) {
			 throw new GreaterMarksException();
		 }
		 else {
			 System.out.println("Your details are with us!");
		 }
	  
	 }
}
public class CustomExceptionDemo {

	public static void main(String[] args) {
		Student s = new Student(10000,"jyo",95);
		s.insert();
		Student s1 = new Student(1002,"mayee",120);
	}

}
