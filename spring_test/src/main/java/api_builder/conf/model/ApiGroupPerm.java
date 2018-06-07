package api_builder.conf.model;

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

@Entity
@Table(name="api_group_perm")
public class ApiGroupPerm {
	private Integer id;
	private ApiBean apiBean;
	private ApiGroup apiGroup;
	private Boolean selection;
	private Boolean deletion;
	private Boolean updating;
	private Boolean creation;
	
	public ApiGroupPerm() {
		super();
	}
	
	public ApiGroupPerm(Integer id, ApiBean apiBean, ApiGroup apiGroup, Boolean selection,
			Boolean deletion, Boolean updating, Boolean creation) {
		super();
		this.id = id;
		this.apiBean = apiBean;
		this.apiGroup = apiGroup;
		this.selection = selection;
		this.deletion = deletion;
		this.updating = updating;
		this.creation = creation;
	}
	
	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne
    @JoinColumn(name="api_bean")
	public ApiBean getApiBean() {
		return apiBean;
	}
	
	public void setApiBean(ApiBean apiBean) {
		this.apiBean = apiBean;
	}
	
	@OneToOne
    @JoinColumn(name="api_group")
	public ApiGroup getApiGroup() {
		return apiGroup;
	}
	public void setApiGroup(ApiGroup apiGroup) {
		this.apiGroup = apiGroup;
	}

	@Column(name="selection")
	public Boolean getSelection() {
		return selection;
	}
	public void setSelection(Boolean selection) {
		this.selection = selection;
	}
	
	@Column(name="deletion")
	public Boolean getDeletion() {
		return deletion;
	}
	public void setDeletion(Boolean deletion) {
		this.deletion = deletion;
	}
	
	@Column(name="updating")
	public Boolean getUpdating() {
		return updating;
	}
	public void setUpdating(Boolean updating) {
		this.updating = updating;
	}
	
	@Column(name="creation")
	public Boolean getCreation() {
		return creation;
	}
	public void setCreation(Boolean creation) {
		this.creation = creation;
	}
	
	
}
