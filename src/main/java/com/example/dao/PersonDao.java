package com.example.dao;

import java.util.List;
import javax.ejb.Local;
import org.perfectjpattern.jee.api.integration.dao.IBaseDao;
import com.example.entities.Person;

@Local
public interface PersonDao extends IBaseDao<Long, Person> {

	public List<Person> byFirstName(String firstName);

	public List<Person> byLastName(String lastName);

	public Person beEmail(String email);

}
