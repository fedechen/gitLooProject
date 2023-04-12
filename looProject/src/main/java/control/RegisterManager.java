package control;




import java.util.List;

import dao.EmployeeDao;
import model.Employee;

public class RegisterManager {

	EmployeeDao dao = new EmployeeDao();
	
	public Employee getNewEmployee() {
		return new Employee();
	}

	public void saveEmployee(Employee employee) {

		
		dao.save(employee);
	}
	
	public List<Employee> getListEmployees() {
		
		List<Employee> employees = dao.listAll(new Employee());
		return employees;
	}

}
