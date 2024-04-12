package EmployeeCRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import EmployeeCRUD.Dao.EmpDao;
import EmployeeCRUD.Dto.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpDao empdao;
	
	@GetMapping("/teacher")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employee =empdao.getAllEmployees();
		if(employee.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		else {
			return ResponseEntity.of(Optional.of(employee));
		}
	}
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable int id){
		Employee employee =empdao.findEmployeeById(id);
		if(employee==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		else {
			return ResponseEntity.of(Optional.of(employee));
		}
	}

	@PostMapping("/teacher")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee t){
		boolean Res=empdao.saveEmployee(t);
		if(Res)
		{
			return ResponseEntity.of(Optional.of("Saved"));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
	
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
		
		boolean res=empdao.deleteEmployeeById(id);
		if(res) {
			return ResponseEntity.of(Optional.of("Deleted Successfully"));

		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
	@PatchMapping("/teacher")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee t){
		boolean Res=empdao.updateEmployee(t);
		if(Res)
		{
			return ResponseEntity.of(Optional.of("Saved"));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
	}
}
