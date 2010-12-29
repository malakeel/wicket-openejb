package com.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class BasePage extends WebPage {

	public BasePage() {
		add(new StyleSheetReference("stylesheet", BasePage.class, "style.css"));
		add(new SearchForm("search-form"));
	}
}


