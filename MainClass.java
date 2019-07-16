package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImp;
import com.cg.eis.service.Validation;

public class MainClass {
	public static Employee acceptDetails() {
		Employee emp=new Employee();
		Validation valid=new Validation();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		boolean id_result=valid.validateId(id);
		if(id_result==false)
		{
			System.out.println("ID should contain excatly 3 digits\n");
		}
		else {
			emp.setId(id);
			System.out.println("Enter employee name:");
			String name=sc.next();
			boolean name_result=valid.validateName(name);
			if(name_result==false) {
				System.out.println("Employee name should start with capital letter and should contain minimum 2 small letters.\n");
			}
			else {
				emp.setName(name);
				System.out.println("Enter designation:");
				String des=sc.next().toLowerCase();
				if(des.equals("manager")|| des.equals("clerk")||des.equals("software associate")||des.equals("programmer"))
				{
					emp.setDesignation(des);
					if(des.equals("system associate"))
					{
						System.out.println("Enter salary which is >5000 &<20000:");
						double sal=sc.nextDouble();
						emp.setSalary(sal);
						if(sal>5000||sal<20000)
						{
							emp.setInsuranceScheme("Scheme C");
						}
						else {
							System.out.println("Not a correct salary for this designation.\n");
							
						}
					}
					else if(des.equals("programmer"))
					{
						System.out.println("Enter salary which is >=20000 & <40000");
						double sal=sc.nextDouble();
						emp.setSalary(sal);
						if(sal>=20000||sal<40000)
						{
							emp.setInsuranceScheme("Scheme B");
						}
						else {
							System.out.println("Not a correct salary for this designation.\n");
							
						}
						
						
					}
					else if(des.equals("manager"))
					{
						System.out.println("Enter salary which is >=40000");
						double sal=sc.nextDouble();
						emp.setSalary(sal);
						if(sal>=40000)
						{
							emp.setInsuranceScheme("Scheme A");
						}
						else {
							System.out.println("Not a correct salary for this designation.\n");
							
						}
						
						
					}
					else if(des.equals("clerk"))
					{
						System.out.println("Enter salary which is <5000");
						double sal=sc.nextDouble();
						emp.setSalary(sal);
						if(sal<5000)
						{
							emp.setInsuranceScheme("No Scheme");
						}
						else {
							System.out.println("Not a correct salary for this designation.\n");
							
						}
						
						
					}
					else {
						System.out.println("Enter proper designation.\n");
					}
				}
			}
			
		}
		return emp;
	}
		public static void displayDetails(Employee emp) {
			System.out.println("EmployeeId "+emp.getId()+"\nEmployeeName "+emp.getName()+"\nEmployee Salary "+emp.getSalary()+"\nEmployee Designation "+emp.getDesignation()+"\nEmployee insurance scheme "+emp.getInsuranceScheme());
		}
		public static void main(String[] args) {
			EmployeeServiceImp esp=new EmployeeServiceImp();
			Scanner sc=new Scanner(System.in);
			while(true) {
			System.out.println("1.Add employee"+ "\n 2.Display Details"+"\n 3.Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				Employee emp=acceptDetails();
				emp=esp.addEmployee(emp);
				break;
			case 2:
				System.out.println("Enter Employee Id:");
				int e_id=sc.nextInt();
				Employee emp1=esp.getEmployee(e_id);
				System.out.println("Display Details");
				displayDetails(emp1);
				break;
			case 3:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Choice");
				
				
				
				
				
			}
			
			
		}
		
		
	}

}
