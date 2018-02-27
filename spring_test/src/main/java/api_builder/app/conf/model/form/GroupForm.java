package api_builder.app.conf.model.form;

import api_builder.app.conf.model.ApiGroup;

public class GroupForm {
	private ApiGroup apiGroup;
	
	private ApiGroupPermWrapper apiGroupPermWrapper;

	public ApiGroup getApiGroup() {
		return apiGroup;
	}

	public void setApiGroup(ApiGroup apiGroup) {
		this.apiGroup = apiGroup;
	}

	public ApiGroupPermWrapper getApiGroupPermWrapper() {
		return apiGroupPermWrapper;
	}

	public void setApiGroupPermWrapper(ApiGroupPermWrapper apiGroupPermWrapper) {
		this.apiGroupPermWrapper = apiGroupPermWrapper;
	}
	
	
}
