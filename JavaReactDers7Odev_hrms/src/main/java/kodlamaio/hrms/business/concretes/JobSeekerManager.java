package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.VerificationByEmailService;
import kodlamaio.hrms.business.abstracts.VerificationByNviService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationByNviService verificationByNviService;
	private VerificationByEmailService verificationByEmailService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationByNviService verificationByNviService,
			VerificationByEmailService verificationByEmailService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.verificationByNviService = verificationByNviService;
		this.verificationByEmailService = verificationByEmailService;
	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
		
		Result result = isValid(jobSeeker);
		if (!result.isSuccess()) {
			return result;
		}
		
		result =isJobSeekerExists(jobSeeker);
		
		if (!result.isSuccess()) {
			return result;
		}
		
		
		result = verificationByNviService.verify(jobSeeker);
			
		if (!result.isSuccess()) {
			return result;
		}
		
		verificationByEmailService.sendVerificationEmail(jobSeeker);
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(" Eklendi");
		
		
	}

	@Override
	public JobSeeker getJobSeekerByEmail(String email) {
		// TODO Auto-generated method stub
		return this.jobSeekerDao.getByEmail(email);
	}

	@Override
	public JobSeeker getJobSeekerByNationalityId(String nationalityId) {
		// TODO Auto-generated method stub
		return this.jobSeekerDao.getByNationalityId(nationalityId);
	}

	@Override
	public Result isJobSeekerExists(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		if (getJobSeekerByNationalityId(jobSeeker.getNationalityId())!=null) {
			return new ErrorResult("Kullanıcı Kayıtlı");
		}
		if (getJobSeekerByEmail(jobSeeker.getEmail())!=null){
			return new ErrorResult("Kullanıcı Kayıtlı");
		}
		return new SuccessResult();
		
	}

	private Result isValid(JobSeeker jobSeeker) {
		String result ="";
		if (jobSeeker.getDateOfBirth() == null) {
			result+="Doğum Tarihi boş olamaz ";
		}
		if (jobSeeker.getEmail() == null) {
			result+="Email boş olamaz";
		}
		if (jobSeeker.getFirstName() == null) {
			result+="Ad alanı boş olamaz";
		}
		if (jobSeeker.getLastName() == null) {
			result+="Soyadı boş olamaz";
		}
		if (jobSeeker.getNationalityId() == null) {
			result+="TC Kimlik No boş olamaz";
		}
		if (jobSeeker.getPasswordHash() == null) {
			result+="Parola boş olamaz";
		}
		
		if (result.length()>1) {
			return new ErrorResult(result);
		}
		
		return new SuccessResult();
	}




}
