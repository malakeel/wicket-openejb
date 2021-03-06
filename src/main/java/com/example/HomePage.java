package com.example;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import com.example.dao.PersonDao;
import com.example.entities.Person;

public class HomePage extends WebPage {
	@EJB(name = "PersonDaoLocal")
	private PersonDao dao;

	private static final long serialVersionUID = 1L;

	public HomePage() {

		List<Person> all;
		try {
			all = dao.findAll();

		} catch (Exception e) {
			all = new LinkedList<Person>();
			e.printStackTrace();
			new JNDITree();
		}

		if (all.size() == 0) {
			this.populateData();
			all = dao.findAll();
		}
		ListView<Person> lstView = new ListView<Person>("listview", all) {
			@Override
			protected void populateItem(ListItem<Person> item) {
				Person p = item.getModelObject();
				item.add(new Label("firstName", p.getFirstName()));
				item.add(new Label("lastName", p.getLastName()));
				item.add(new Label("email", p.getEmail()));
			}
		};
		add(lstView);
	}

	private void populateData() {
		Person sample = new Person();
		sample.setFirstName("John");
		sample.setLastName("Smith");
		sample.setEmail("email1@example.com");
		dao.create(sample);
		sample = new Person();
		sample.setFirstName("Peter");
		sample.setLastName("Smith");
		sample.setEmail("email2@example.com");
		dao.create(sample);
	}
}
