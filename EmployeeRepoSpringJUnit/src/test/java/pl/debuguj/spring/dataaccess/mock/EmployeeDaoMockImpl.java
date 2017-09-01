package pl.debuguj.spring.dataaccess.mock;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.debuguj.spring.dataaccess.EmployeeDao;
import pl.debuguj.spring.dataaccess.RecordNotFoundException;
import pl.debuguj.spring.domain.Employee;


@Repository
public class EmployeeDaoMockImpl implements EmployeeDao {

	List<Employee> list;
	
	public EmployeeDaoMockImpl() {
		list = new ArrayList<Employee>();
		list.add(new Employee(5, "Stanis�aw", "Lem", 5000));
		list.add(new Employee(6, "Andrzej", "Pilipiuk", 7000));
		list.add(new Employee(7, "Janusz", "Zajdel", 9000));
		list.add(new Employee(8, "Adam", "Wisniewski", 10000));
	}
	
	@Override
	public void createEmployee(Employee e) {
		list.add(e);
		
	}

	@Override
	public void deleteEmployeeById(Employee e) throws RecordNotFoundException {
		if(list.contains(e)){
			list.remove(e);
		} else {
			throw new RecordNotFoundException();
		}		
	}

	@Override
	public Employee findEmployeeById(int id) throws RecordNotFoundException {
			
		for(Employee e : list){
			if(e.getId() == id){
				return e;
			} 		
		} 		
		throw new RecordNotFoundException();	
	}
	
	@Override
	public List<Employee> getAllEmployees() {		
		return list;
	}

}
