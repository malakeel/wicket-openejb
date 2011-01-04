package com.example;

import org.wicketstuff.javaee.naming.IJndiNamingStrategy;

public class OpenEjbNamingStrategy implements IJndiNamingStrategy {

	private static final long serialVersionUID = 1L;

	public String calculateName(String ejbName, Class<?> ejbType) {
		return (ejbName == null ? "openejb:"+ejbType.getSimpleName() + "Local" : ejbName);
	}

}
