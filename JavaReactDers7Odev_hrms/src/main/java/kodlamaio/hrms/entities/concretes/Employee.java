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
@Table(name="employees")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User{

	

		//@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		//@Column(name="user_id")
	    //private int userId;
		
		@Column(name="first_name")
	    private String firstName;
		
		@Column(name="last_name")
	    private String lastName;
		
		
		@Column(name="hire_date")
	    private Date hireDate;
		
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


		public Date getHireDate() {
			return hireDate;
		}

		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
}
