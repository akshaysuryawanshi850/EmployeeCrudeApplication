package com.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

 
import com.hibernate.model.Employee;
import com.hibernate.util.Utility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee emp) {
		SessionFactory factory = Utility.getsesionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(emp);

		tx.commit();

		System.out.println("Save Data");
		session.close();

	}

	@Override
	public boolean deleteEmployeeById(int id) 
	{
		SessionFactory factory=Utility.getsesionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		 Employee emp=session.get(Employee.class,id);
		 if(emp!=null)
		 {
			 session.delete(emp);
			 
		 }
			
		 tx.commit();
		 session.close();
		return false;
		
	}

	@Override
	public boolean readData(int id) 
	{
		SessionFactory factory=Utility.getsesionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp=session.load(Employee.class,id);
		System.out.println(emp);
		 tx.commit();
		 session.close();
		return false;
	}

		@Override
	public List<Employee> findAllEmployess() {
		SessionFactory factory =Utility.getsesionFactory();

		Session session = factory.openSession();

		Query qury=session.createQuery("from Employee e");
		 List<Employee> empList=qury.list();
	 	Transaction tx=session.beginTransaction();
	 	
	 	 tx.commit();
		 factory.close();
		 session.close();
		 
		return empList;
	}

	@Override
	public Employee updateemp(int id)
	{
		
			SessionFactory factory=Utility.getsesionFactory();
			Session session=factory.openSession();
	 		Transaction tx=session.beginTransaction();
			 
	 		Employee emp=(Employee)session.load(Employee.class,id);
	 		
	 	
			 tx.commit();
		
		return emp;
	}

	@Override
	public Employee update2(Employee emp) 
	{
		SessionFactory factory=Utility.getsesionFactory();
		Session session=factory.openSession();
 		Transaction tx=session.beginTransaction();
 		session.update(emp);
 		tx.commit();

		return emp ;
	}

}
