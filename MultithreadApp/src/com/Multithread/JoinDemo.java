package com.Multithread;

public class JoinDemo extends Thread{
public void run() {
for(int i=1;i<=10;i++) {
System.out.println("Child Thread i value: "+i);
}
}
public static void main(String[] args) {

JoinDemo jd=new JoinDemo();
jd.start();
try {
jd.join();   //orphan thread
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Parent Thread");
}
}
