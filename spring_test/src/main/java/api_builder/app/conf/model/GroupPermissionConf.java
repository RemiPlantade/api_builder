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

@Entity
@Table(name="group_permission_conf")
public class GroupPermissionConf {
	private Integer id;
	private EntityConf idEntityConf;
	private GroupConf idGroupConf;
	private Boolean selection;
	private Boolean deletion;
	private Boolean updating;
	private Boolean creation;
	
	public GroupPermissionConf() {
		super();
	}
	
	public GroupPermissionConf(Integer id, EntityConf idEntityConf, GroupConf idGroupConf, Boolean selection,
			Boolean deletion, Boolean updating, Boolean creation) {
		super();
		this.id = id;
		this.idEntityConf = idEntityConf;
		this.idGroupConf = idGroupConf;
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
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_entity_conf")
	public EntityConf getIdEntityConf() {
		return idEntityConf;
	}
	
	public void setIdEntityConf(EntityConf idEntityConf) {
		this.idEntityConf = idEntityConf;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
	public GroupConf getIdGroupConf() {
		return idGroupConf;
	}
	public void setIdGroupConf(GroupConf idGroupConf) {
		this.idGroupConf = idGroupConf;
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
