package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface VerificationByEmailService extends VerificationService{
	Result verify(User user,String verificationCode);
	Result sendVerificationEmail(User user);
}
