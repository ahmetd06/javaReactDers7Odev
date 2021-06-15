package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="verifications_by_email")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
public class VerificationByEmail extends Verification{
	
	  //@Id 
	 // @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="verification_id")
    //private int verificationId;
	
	@Column(name="verification_code")
    private String verificationCode;
	
	
	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	
}
