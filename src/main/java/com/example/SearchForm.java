package com.example;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import com.example.entities.Person;


public class SearchForm extends Form<Person> {

	public SearchForm(String id) {
		super(id);
		// add(new Label("firstName","My FirstName"));
	}

}
