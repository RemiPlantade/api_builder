package api_builder.conf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="api_bean")
public class ApiBean {
	
	private Integer id;
	private String name;
	private Boolean managed;
	
	
	public ApiBean() {
		super();
	}

	public ApiBean(Integer id, String name, Boolean managed) {
		super();
		this.id = id;
		this.name = name;
		this.managed = managed;
	}
	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name", length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="managed")
	public Boolean getManaged() {
		return managed;
	}
	public void setManaged(Boolean managed) {
		this.managed = managed;
	}
	
	
}
