package api_builder.app.conf.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="entity_conf")
public class EntityConf {
	
	private Integer id;
	private String name;
	private Boolean managed;
	
	
	public EntityConf() {
		super();
	}

	public EntityConf(Integer id, String name, Boolean managed) {
		super();
		this.id = id;
		this.name = name;
		this.managed = managed;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getManaged() {
		return managed;
	}
	public void setManaged(Boolean managed) {
		this.managed = managed;
	}
	
	
}
