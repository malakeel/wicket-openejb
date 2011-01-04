package com.example;

import org.apache.wicket.injection.ComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;
import org.wicketstuff.javaee.naming.IJndiNamingStrategy;

public class WicketApplication extends WebApplication {

	@Override
	protected void init() {
		System.out.println("Starting ....");
		IJndiNamingStrategy nameStrategy = new OpenEjbNamingStrategy();
		ComponentInjector jeeInjector = new JavaEEComponentInjector(this,
				nameStrategy);
		addComponentInstantiationListener(jeeInjector);
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

}
