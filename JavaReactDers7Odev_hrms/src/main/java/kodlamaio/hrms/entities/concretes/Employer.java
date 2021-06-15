package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User { 
		//@Id
		//@GeneratedValue(strategy = GenerationType.IDENTITY) 
		//@Column(name="user_id")
	    //private int userId;
		
		@Column(name="company_name")
	    private String companyName;
		
		@Column(name="web_site")
	    private String webSite;
		
		
		@Column(name="phone_number")
	    private String phoneNumber;
		
		@Column(name="password_hash")
	    private String passwordHash;

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getWebSite() {
			return webSite;
		}

		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
}
