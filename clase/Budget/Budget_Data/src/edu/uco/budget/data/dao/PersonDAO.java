package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.PersonDTO;


public interface PersonDAO {
	
void create(PersonDTO budget);
	
	List<PersonDTO> find(PersonDTO budget);
	
	void update(PersonDTO budget);
	
	void delete(UUID id);

}
