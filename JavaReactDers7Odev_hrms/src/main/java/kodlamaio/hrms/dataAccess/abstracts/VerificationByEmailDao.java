package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.VerificationByEmail;

public interface VerificationByEmailDao  extends JpaRepository<VerificationByEmail,Integer>{

	VerificationByEmail getByUserId(int userId);
}
