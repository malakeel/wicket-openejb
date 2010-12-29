package com.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.perfectjpattern.jee.integration.dao.AbstractJpaManagedBaseDao;
import com.example.entities.Person;

@Stateless(name="PersonDao",mappedName="PersonDao")
public class PersonDaoImpl extends AbstractJpaManagedBaseDao<Long, Person>
		implements PersonDao {

	public PersonDaoImpl() {
		super(Person.class);
	}

	@PersistenceContext(unitName = "contacts")
	public void setEntityManager(EntityManager em) {
		super.setEntityManager(em);
	}
	
	public List<Person> byFirstName(String firstName) {
		return null;
	}

	public List<Person> byLastName(String lastName) {
		return null;
	}

	public Person beEmail(String email) {
		return null;
	}

}
