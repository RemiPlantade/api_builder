package api_builder.app.conf.model.spring;

import java.util.ArrayList;
import java.util.List;

import api_builder.app.conf.model.UserPermissionConf;

public class UserPermissionsConfWrapper {
	private List<UserPermissionConf> userPermList;

	public List<UserPermissionConf> getUserPermList() {
		return userPermList;
	}

	public void setUserPermList(List<UserPermissionConf> list) {
		this.userPermList = list;
	}
}
