package EmployeeCRUD.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private  int id;
	private String name;
	private String gender;
	@Column(unique = true)
	private String Dept;
	
}
