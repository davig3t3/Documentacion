package edu.uco.budget.data.dao;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.YearDTO;


public interface YearDAO {
	
void create(YearDTO budget);
	
	List<YearDTO> find(YearDTO budget);
	
	void update(YearDTO budget);
	
	void delete(UUID id);

}
