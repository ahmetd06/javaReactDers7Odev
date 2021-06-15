package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="verifications_by_hrms_staff")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
public class VerificationByHrmsStaff extends Verification{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//@Column(name="verification_id")
    //private int verificationId;
	

	@Column(name="confirming_user_id")
    private int confirmingUserId;
	
	public int getConfirmingUserId() {
		return confirmingUserId;
	}

	public void setConfirmingUserId(int confirmingUserId) {
		this.confirmingUserId = confirmingUserId;
	}

	    
}
