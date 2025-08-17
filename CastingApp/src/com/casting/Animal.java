package com.casting;

class Cat{
	void sound() {
		System.out.println("meow");
	}
}
class Tiger extends Cat{
	void sound() { //over riding method
		System.out.println("Roarrrrrrrrrrrrr");
	}
	void food() {
		System.out.println("Non veg");
	}
}
public class Animal {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
					Cat c ; //reference variable(dynamic binding)
					c = new Cat();
					c.sound();
					c = new Tiger();
					c.sound();
					//class casting
					((Tiger)c).food();// etra spl method soo raadu  (class casting have to do )
					
					
	}

}
