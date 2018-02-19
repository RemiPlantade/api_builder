package api_builder.app.conf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name="user")
public class User {
	private  Integer id;
	private String firstname;
	private String lastname;
	private String token;
	private Integer maxquota;
	private Integer actualquota;

	public User() {
		super();
	}

	public User(Integer id, String firstname, String lastname, String token, Integer maxquota, Integer actualquota) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.token = token;
		this.maxquota = maxquota;
		this.actualquota = actualquota;
	}
	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="firstname", length=45)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name="lastname", length=45)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name="token",length=45)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name="maxquota")
	public Integer getMaxquota() {
		return maxquota;
	}
	public void setMaxquota(Integer maxquota) {
		this.maxquota = maxquota;
	}
	@Column(name="actualquota")
	public Integer getActualquota() {
		return actualquota;
	}
	public void setActualquota(Integer actualquota) {
		this.actualquota = actualquota;
	}



}
