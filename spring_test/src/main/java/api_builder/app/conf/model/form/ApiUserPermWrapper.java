package api_builder.app.conf.model.form;

import java.util.ArrayList;
import java.util.List;

import api_builder.app.conf.model.ApiUserPerm;

public class ApiUserPermWrapper {
	private List<ApiUserPerm> userPermList;

	public List<ApiUserPerm> getUserPermList() {
		return userPermList;
	}

	public void setUserPermList(List<ApiUserPerm> list) {
		this.userPermList = list;
	}
}
