package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationByEmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerificationByEmailService verificationByEmailService;
	
	public EmployerManager(EmployerDao employerDao, VerificationByEmailService verificationByEmailService) {
		super();
		this.employerDao = employerDao;
		this.verificationByEmailService = verificationByEmailService;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		// TODO Auto-generated method stub
		Result result = isValid(employer);
		if (!result.isSuccess()) {
			return result;
		}
		
		result =isEmployerExists(employer);
		
		if (!result.isSuccess()) {
			return result;
		}
		
		verificationByEmailService.sendVerificationEmail(employer);
		
		this.employerDao.save(employer);
		return new SuccessResult("İşveren Eklendi. Geçerli olması için Email doğrulaması ve Personel doğrulaması bekleniyor. ");
		
		
	}
	private Result isValid(Employer employer) {
		String result ="";
		if (employer.getCompanyName() == null) {
			result+="Şiret adı boş olamaz ";
		}
		if (employer.getEmail() == null) {
			result+="Email boş olamaz";
		}
		if (employer.getPhoneNumber() == null) {
			result+="Telefon numarası alanı boş olamaz";
		}
		if (employer.getWebSite() == null) {
			result+="İnternet Sitesi alanı boş olamaz";
		}
		
		if (employer.getPasswordHash() == null) {
			result+="Parola boş olamaz";
		}
		
		if (result.length()>1) {
			return new ErrorResult(result);
		}
		
		return new SuccessResult();
	}


	@Override
	public Employer getEmployerByEmail(String email) {
		// TODO Auto-generated method stub
		return employerDao.getByEmail(email);
	}

	@Override
	public Result isEmployerExists(Employer employer) {
		// TODO Auto-generated method stub
		if (getEmployerByEmail(employer.getEmail())!=null){
			return new ErrorResult("Kullanıcı Kayıtlı");
		}
		return new SuccessResult();
	}

}
