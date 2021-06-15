package kodlamaio.hrms.entities.concretes;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="verifications_by_nvi")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
public class VerificationByNvi extends Verification {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//@Column(name="verification_id")
    //private int verificationId;
	

	  
}
