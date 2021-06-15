package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationByEmailService;
import kodlamaio.hrms.core.utilities.dates.Dates;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationByEmailDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationByEmail;
@Service
public class VerificationByEmailManager implements VerificationByEmailService{

	VerificationByEmailDao verificationByEmailDao;
	
	public VerificationByEmailManager(VerificationByEmailDao verificationByEmailDao) {
		super();
		this.verificationByEmailDao = verificationByEmailDao;
	}

	@Override
	public Result verify(User user, String verificationCode) {
		
		VerificationByEmail verificationByEmail =verificationByEmailDao.getByUserId(user.getId());
		
		if (verificationByEmail.getVerificationCode() == verificationCode) {
			
			verificationByEmail.setIsVerified(true);
			verificationByEmail.setVerificationDate(Dates.getLocalDate());
			verificationByEmailDao.save(verificationByEmail);
			
			return new SuccessResult("Doğrulama Başarılı");
		}
		
		return new ErrorResult("Doğrulama Başarısız");
	}

	@Override
	public Result sendVerificationEmail(User user) {

		
		
		String randomNumber = getRandomNumber();
		SendEmail(user.getEmail(),randomNumber);
		
		VerificationByEmail verificationByEmail= new VerificationByEmail();
		
		verificationByEmail.setIsVerified(false);
		verificationByEmail.setUserId(user.getId());
		verificationByEmail.setVerificationCode(randomNumber);
		
		// gönderdiğimiz kodu tutuyoruzki kayıt sonrası doğrulamaya geldiğinde karşılaştıralım
		verificationByEmailDao.save(verificationByEmail);
		
		
		return new SuccessResult("Doğrulama kodu Emaile gönderildi.");
	}

	private String getRandomNumber() {
		 int min = 50000;
	      int max = 999999;
	        
	      int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
	      return String.valueOf(randomInt);
	}
	
	private Result SendEmail(String email, String verificationCode) {
		
		return new SuccessResult(email + " Eposta adresine " + verificationCode +" doğrulama kodu gönderimi simüle edildi");
	}
}
