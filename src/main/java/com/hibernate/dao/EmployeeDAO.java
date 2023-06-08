package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.Employee;

public interface EmployeeDAO 
{
	void saveEmployee(Employee emp);
	boolean deleteEmployeeById(int id);
	boolean readData(int id); 
	Employee updateemp(int id );
	List<Employee> findAllEmployess();
	Employee update2(Employee emp);

}
