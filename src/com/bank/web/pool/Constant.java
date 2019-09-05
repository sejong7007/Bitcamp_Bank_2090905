package com.bank.web.pool;

import java.io.File;

public class Constant {

	public static final String FILE_PATH = 
			String.format("C:%sUsers%suser%seclipes-jee%sjee-bitcampt%sWebContent%sresources%stext%s",
					File.separator,
					File.separator,
					File.separator,
					File.separator,
					File.separator,
					File.separator,
					File.separator,
					File.separator);
	
	
	public static final String VIEW_PATH = "WEB-INF/views/%s/%s.jsp";
}
