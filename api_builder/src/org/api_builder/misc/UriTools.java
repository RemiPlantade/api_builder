package org.api_builder.misc;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

public class UriTools {

	public static String getUserIdFromURI(String uri){
		return uri.split("/")[3];
	}
	
	public static String getApiNameFromURI(String uri){
		return uri.split("/")[4];
	}
	
	public static String getRequestFromURI(String uri){
		return uri.split("/")[5];
	}
}
