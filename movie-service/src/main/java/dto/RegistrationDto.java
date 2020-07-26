package dto;

public class RegistrationDto {

	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String cnfPassword;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcnfPassword() {
		return cnfPassword;
	}
	public void setcnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}
	
	@Override
	public String toString() {
		return "RegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", cnfPassword=" + cnfPassword 
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getcnfPassword()=" + getcnfPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
