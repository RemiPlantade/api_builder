package api_builder.conf.model.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import api_builder.conf.model.ApiBean;

public class ApiBeanFormatter  implements Formatter<ApiBean>{
	@Override
	public String print(ApiBean arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return arg0.getId()+":"+arg0.getName();
	}

	@Override
	public ApiBean parse(String arg0, Locale arg1) throws ParseException {
		ApiBean group = new ApiBean();
		int idxSeparator = arg0.indexOf(":");
		int id = Integer.parseInt(arg0.substring(0, idxSeparator));
		String name = arg0.substring(idxSeparator, arg0.length());
		group.setId(id);
		group.setName(name);
		return group;
	}
}
