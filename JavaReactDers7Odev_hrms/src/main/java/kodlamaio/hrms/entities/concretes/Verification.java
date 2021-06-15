package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="verifications")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
public class Verification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
    private int id;
	
	@Column(name="verification_date")
    private LocalDate verificationDate;
	
	@Column(name="is_verified")
    private Boolean isVerified;
	
	@Column(name="user_id")
    private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public LocalDate getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(LocalDate verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
}
