package api_builder.app.conf.model.form;

import api_builder.app.conf.model.ApiUser;

public class UserForm {
	
	private ApiUser apiUser;
	
	private ApiUserPermWrapper apiUserPermWrapper;

	public ApiUser getApiUser() {
		return apiUser;
	}

	public void setApiUser(ApiUser userconf) {
		this.apiUser = userconf;
	}

	public ApiUserPermWrapper getApiUserPermWrapper() {
		return apiUserPermWrapper;
	}

	public void setApiUserPermWrapper(ApiUserPermWrapper apiUserPermWrapper) {
		this.apiUserPermWrapper = apiUserPermWrapper;
	}
	
	

}