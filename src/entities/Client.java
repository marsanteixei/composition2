package entities;

import java.util.Date;

public class Client {
	private String id;
	private String name;
	private String password;
	private String email;
	private Date birthDate;
	private String numberCard;

	public Client() {

	}

	public Client(String id, String name, String password, String email, Date birthDate, String numberCard) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.numberCard = numberCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public boolean validatePayment(String numberCard) {
		if (this.numberCard.equals(numberCard)) {
			return true;
		} else
			return false;
	}
}
