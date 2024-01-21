package application;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		//Setting up Locale and instantiating Scanner
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		//Creating List with the specified number of employees
		System.out.print("How many employees will be registered? ");
		int n = input.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		//Implementing "for" to register employees
		for (int i = 0; i<n; i++) {
			
			System.out.println("\nEmployee #" + (i+1) + ":");
			
			System.out.print("ID: ");
			Integer id = input.nextInt();
			
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			
			System.out.print("Salary: ");
			Double salary = input.nextDouble();
			
			//Instantiating class to add in the List
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);			
		}
		
		//Raising salary with a search function
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int idsalary = input.nextInt();
		Integer pos = position(list, idsalary);
		
		if (pos == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = input.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		//Printing final list of employees
		System.out.println("\nList of employees:");
		for (Employee e : list) {
			System.out.println(e);
		}
		
		input.close();

	}
	
	//Implementing a function to find the position of the specified id
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
