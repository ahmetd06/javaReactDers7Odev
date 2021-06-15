package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;

import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDao.save(employee);
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
