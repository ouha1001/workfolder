package demo.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rateme_user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT r FROM User r"),
	@NamedQuery(name = "User.findByUserName", query = "SELECT r FROM User r WHERE r.userName = :userName")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String userName;

	@Column(name = "eMail", length = 50, nullable = false)
	private String email;

	@Column(name = "firstname", length = 20, nullable = false)
	private String firstName;

	@Column(name = "lastname", length = 20, nullable = false)
	private String lastName;

	@Column(length = 30, nullable = false)
	private String street;

	@Column(length = 20, nullable = false)
	private String streetNr;

	@Column(length = 30, nullable = false)
	private String city;

	@Column(length = 20, nullable = false)
	private String zip;

	@Column(name = "password_hash", nullable = false)
	private byte[] passwordHash;

	@Column(name = "password_salt", nullable = false)
	private byte[] passwordSalt;

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNr() {
		return streetNr;
	}

	public void setStreetNr(String streetNr) {
		this.streetNr = streetNr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public byte[] getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}