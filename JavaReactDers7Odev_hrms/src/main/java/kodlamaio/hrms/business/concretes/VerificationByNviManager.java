package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationByNviService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class VerificationByNviManager implements VerificationByNviService{

	@Override
	public Result verify(User user) {
		// TODO Auto-generated method stub
		return new SuccessResult("Mernisten Doğrulama Başarılı Simülasyonu");
	}

}
