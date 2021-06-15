package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationByHrmsStaffService;
import kodlamaio.hrms.core.utilities.dates.Dates;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationByHrmsStaffDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationByHrmsStaff;
@Service
public class VerificationByHrmsStaffManager implements  VerificationByHrmsStaffService{

	//bunu loginde kullanıcam. doğrulanmışmı diye. yönetici sonradan onaylayacağından kullanıcı kaydı esnasında doğrulama olmayacak
	
	VerificationByHrmsStaffDao verificationBystaffDao;
	public VerificationByHrmsStaffManager(VerificationByHrmsStaffDao verificationBystaffDao) {
		super();
		this.verificationBystaffDao = verificationBystaffDao;
	}
	@Override
	public Result verify(User user) {
		VerificationByHrmsStaff verificationByHrmsStaff= new VerificationByHrmsStaff();
		verificationByHrmsStaff.setConfirmingUserId(11);
		verificationByHrmsStaff.setIsVerified(true);
		verificationByHrmsStaff.setUserId(user.getId());
		verificationByHrmsStaff.setVerificationDate(Dates.getLocalDate());
		
		verificationBystaffDao.save(verificationByHrmsStaff);
		
		return new SuccessResult("Sistem kullanıcısı onayladı");
	}

}
