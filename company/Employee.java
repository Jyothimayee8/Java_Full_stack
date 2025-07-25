package com.company;

import java.util.Scanner;

class Employee {
    // Fields
    int id;
    String name;
    long salary;
    long hrf;
    long pf;
    long netSalary;

    // Static dress code for all employees
    static String dressCode = "Wear formal dress from Monday to Friday, casual on Saturday";

    // Constructor
    public Employee(int id, String name, long salary, long hrf, long pf) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hrf = hrf;
        this.pf = pf;
    }

    // Method to calculate net salary
    public void calculateNetSalary() {
        netSalary = (salary + hrf) - pf;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Salary     : " + salary);
        System.out.println("HRA        : " + hrf);
        System.out.println("PF         : " + pf);
        System.out.println("Net Salary : " + netSalary);

        if (netSalary < 50000) {
            System.out.println("Eligible for Bonus");
        } else {
            System.out.println("Not Eligible for Bonus");
        }

        System.out.println("Dress Code : " + dressCode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter Employee ID       : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Employee Name     : ");
        String name = scanner.nextLine();

        System.out.print("Enter Basic Salary   : ");
        long salary = scanner.nextLong();

        System.out.print("Enter HRF Amount     : ");
        long hrf = scanner.nextLong();

        System.out.print("Enter PF Amount      : ");
        long pf = scanner.nextLong();

        // Create Employee object and process
        Employee emp = new Employee(id, name, salary, hrf, pf);
        emp.calculateNetSalary();
        emp.displayDetails();
        scanner.close();
    }
}
