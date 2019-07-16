package com.cg.eis.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean validateId(int eid) {
		String id=Integer.toString(eid);
		Pattern p=Pattern.compile("[0-9]{3}");
		Matcher mt=p.matcher(id);
	
		
		return mt.matches();
	}

	public boolean validateName(String name) {
		Pattern pt=Pattern.compile("[A-Z][a-z]{2,}");
		Matcher mt=pt.matcher(name);
		
		
		return mt.matches();
	}
	

}
