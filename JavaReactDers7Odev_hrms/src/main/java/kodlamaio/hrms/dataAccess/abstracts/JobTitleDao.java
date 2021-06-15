package kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle; 
public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	Result getByName(String name);
}
