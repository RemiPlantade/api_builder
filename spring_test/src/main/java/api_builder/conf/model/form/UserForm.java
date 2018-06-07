package api_builder.conf.model.form;

import javax.validation.Valid;

import api_builder.conf.model.ApiUser;

public class UserForm {
	@Valid
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
