package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

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

		System.setProperty("java.naming.factory.initial",
				"org.apache.openejb.client.LocalInitialContextFactory");
		
		initContext();
	}

	private void initContext() {
		try {
			Properties props = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream input = loader.getResourceAsStream("jndi.properties");
			if (input == null) {
				throw new IllegalStateException(
						"Could not find jndi.properties in class path\n");
			}
			props.load(input);
			new InitialContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

}
