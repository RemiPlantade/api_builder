package api_builder.app.conf.model.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.model.ApiUser;

public class ApiUserFormatter implements Formatter<ApiUser>{

	@Override
	public String print(ApiUser arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return arg0.getId()+":"+arg0.getUsername();
	}

	@Override
	public ApiUser parse(String arg0, Locale arg1) throws ParseException {
		ApiUser user = new ApiUser();
		int idxSeparator = arg0.indexOf(":");
		int id = Integer.parseInt(arg0.substring(0, idxSeparator));
		String name = arg0.substring(idxSeparator, arg0.length());
		user.setId(id);
		user.setUsername(name);
		return user;
	}

}
