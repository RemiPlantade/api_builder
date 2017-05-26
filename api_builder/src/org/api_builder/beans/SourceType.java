package org.api_builder.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="source_type")
public class SourceType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="sgbd_name")
	private String sgbdName;
	
	@Column(name="driver_class")
	private String driverClass;
	
	public String getSgbdName() {
		return sgbdName;
	}
	public void setSgbdName(String sgbdName) {
		this.sgbdName = sgbdName;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	
}
