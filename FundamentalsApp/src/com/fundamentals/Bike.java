package com.fundamentals;

public class Bike extends Vehicle{

void start() {


System.out.println("turnkey");

System.out.println("press self button");

}



void stop() {


System.out.println("turn key left");

}





public static void main(String[] args) {


//create object

Bike b=new Bike();

b.start();

b.stop();

b.offerDetails();



}

}
