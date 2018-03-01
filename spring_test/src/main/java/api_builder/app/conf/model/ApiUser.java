package api_builder.app.conf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name="api_user")
public class ApiUser {
	
	private  Integer id;
	
	@NotNull
	@Size(min=1, max=32, message="Must be between 1 and 32 characters")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	private String mail;
	
	private String token;
	
	@Min(value=0, message="Minimum value : 0")
	@Max(value=999999999,message="Maximum value : 999999999")
	private Long maxquota = 0L;
	
	private Long actualquota = 0L;
	
	@NotNull(message="You must select a group")
	private ApiGroup group;

	public ApiUser() {
		super();
	}
	
	public ApiUser(Integer id, String username, String mail, String token, Long maxquota, Long actualquota,
			ApiGroup group) {
		super();
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.token = token;
		this.maxquota = maxquota;
		this.actualquota = actualquota;
		this.group = group;
	}

	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="username", length=45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="mail", length=45)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Column(name="token",length=45)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name="maxquota")
	public Long getMaxquota() {
		return maxquota;
	}
	public void setMaxquota(Long maxquota) {
		this.maxquota = maxquota;
	}
	@Column(name="actualquota")
	public Long getActualquota() {
		return actualquota;
	}
	public void setActualquota(Long actualquota) {
		this.actualquota = actualquota;
	}
	@OneToOne
    @JoinColumn(name="idgroup")
	public ApiGroup getGroup() {
		return group;
	}

	public void setGroup(ApiGroup group) {
		this.group = group;
	}
}
