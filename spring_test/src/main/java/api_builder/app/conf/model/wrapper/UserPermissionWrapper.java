package api_builder.app.conf.model.wrapper;

import api_builder.app.conf.model.UserConf;

public class UserPermissionWrapper {
	
	private UserConf userconf;
	
	private UserPermissionsConfWrapper userpermissionconfwrapper;

	public UserConf getUserconf() {
		return userconf;
	}

	public void setUserconf(UserConf userconf) {
		this.userconf = userconf;
	}

	public UserPermissionsConfWrapper getUserpermissionconfwrapper() {
		return userpermissionconfwrapper;
	}

	public void setUserpermissionconfwrapper(UserPermissionsConfWrapper userpermissionconfwrapper) {
		this.userpermissionconfwrapper = userpermissionconfwrapper;
	}
	
	

}
