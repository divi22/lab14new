package com.cg.eis.service;

import java.util.HashMap;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImp implements EmployeeService {
	private static HashMap<Integer,Employee> employees=new HashMap<>();

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employees.put(emp.getId(), emp);
		System.out.println("employee added");
		return emp;
	}

	@Override
	public Employee getEmployee(int e_id) {
		// TODO Auto-generated method stub
		Employee emp=employees.get(e_id);
		return emp;
	}
	

}
