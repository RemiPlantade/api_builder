package api_builder.app.conf.model.form;

import java.util.List;

import api_builder.app.conf.model.ApiGroupPerm;

public class ApiGroupPermWrapper {
	private List<ApiGroupPerm> groupPermList;

	public List<ApiGroupPerm> getGroupPermList() {
		return groupPermList;
	}

	public void setGroupPermList(List<ApiGroupPerm> list) {
		this.groupPermList = list;
	}
	
	
}
