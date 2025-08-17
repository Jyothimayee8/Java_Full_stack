package com.fundamentals;
public interface Vehicle1{

void start();  //abstract method
void stop();
default void offerdetails() { //concrete method
	System.out.println("flashhhh 50% sale");
}

}
