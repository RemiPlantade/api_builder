package api_builder.app.conf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="api_conf")
public class ApiConf {
	
	private Integer id;
	private String paramName;
	private String paramValue;
	private String paramType;
	private String paramKey;
	private boolean modifiable;
	private boolean added;
	private String paramCategory;
	
	
	public ApiConf() {
		super();
	}


	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="param_name", length=45)
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String name) {
		this.paramName = name;
	}

	@Column(name="param_value", length=45)
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	@Column(name="param_type", length=45)
	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	@Column(name="param_key")
	public String getParamKey() {
		return paramKey;
	}


	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	@Column(name="modifiable")
	public boolean isModifiable() {
		return modifiable;
	}


	public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}



	@Column(name="param_category")
	public String getParamCategory() {
		return paramCategory;
	}


	public void setParamCategory(String paramCategory) {
		this.paramCategory = paramCategory;
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof ApiConf 
				&& ((ApiConf)obj).getParamKey().equals(this.getParamKey())
				&&  ((ApiConf)obj).getParamKey().equals(this.getParamValue());
	}

	@Column(name="added")
	public boolean isAdded() {
		return added;
	}


	public void setAdded(boolean added) {
		this.added = added;
	}
}
