package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.VerificationByNvi;

public interface VerificationByNviDao  extends JpaRepository<VerificationByNvi,Integer>{

}
