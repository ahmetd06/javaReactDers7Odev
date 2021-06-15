package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="job_seeker")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class JobSeeker extends User {

 
	//@Id
	//@Column(name="user_id")
    //private int userId;
	
	@Column(name="first_name")
    private String firstName;
	
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="nationality_id")
    private String nationalityId;
	
	@Column(name="date_of_birth")
    private Date dateOfBirth;
	
	
	@Column(name="password_hash")
    private String passwordHash;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	

	    
}
