package api_builder.app.conf.model.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import api_builder.app.conf.model.GroupConf;

public class GroupConfFormatter implements Formatter<GroupConf>{

	@Override
	public String print(GroupConf arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return arg0.getId()+":"+arg0.getName();
	}

	@Override
	public GroupConf parse(String arg0, Locale arg1) throws ParseException {
		GroupConf group = new GroupConf();
		int idxSeparator = arg0.indexOf(":");
		int id = Integer.parseInt(arg0.substring(0, idxSeparator));
		String name = arg0.substring(idxSeparator, arg0.length());
		group.setId(id);
		group.setName(name);
		return group;
	}

}
