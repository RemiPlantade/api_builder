package org.api_builder.misc;

public class UriTools {

	public static String getUserIdFromURI(String uri){
		String[] tokens = uri.split("/");
		if(tokens.length < 4) {
			return null;
		}
		return tokens[3];
	}
	
	public static String getApiNameFromURI(String uri){
		String[] tokens = uri.split("/");
		if(tokens.length < 5) {
			return null;
		}
		return tokens[4];
	}
	
	public static String getRequestFromURI(String uri){
		String[] tokens = uri.split("/");
		if(tokens.length < 6) {
			return null;
		}
		return tokens[5];
	}
}
