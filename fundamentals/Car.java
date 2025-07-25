package com.fundamentals;

public class Car extends Vehicle{
void start() {


		System.out.println("turnkey");

		System.out.println("press self button");

		}



		void stop() {


		System.out.println("turn key left");

		}





		public static void main(String[] args) {


		//create object

		Car b=new Car();

		b.start();

		b.stop();

		b.offerDetails();




	}

}
