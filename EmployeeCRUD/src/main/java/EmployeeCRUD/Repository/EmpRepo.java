package EmployeeCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeCRUD.Dto.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
