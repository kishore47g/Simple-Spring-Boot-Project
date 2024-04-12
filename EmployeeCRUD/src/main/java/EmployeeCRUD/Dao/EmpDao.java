package EmployeeCRUD.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import EmployeeCRUD.Dto.Employee;
import EmployeeCRUD.Repository.EmpRepo;

@Component
public class EmpDao {

	@Autowired
	EmpRepo repo;
	
	public boolean saveEmployee(Employee e) {
		try {
			repo.save(e);
			return true;
		}catch(Exception exc) {
			
		}
		return false;
	}
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee findEmployeeById(int id) {
		
		return repo.findById(id).get();
	}
	
	public boolean deleteEmployeeById(int i) {
		Employee t=findEmployeeById(i);
		if(t!=null){
			repo.delete(t);
			return true;
		}
		return false;
	}
	public boolean updateEmployee(Employee t) {
		try {
			repo.save(t);
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}
	
}
