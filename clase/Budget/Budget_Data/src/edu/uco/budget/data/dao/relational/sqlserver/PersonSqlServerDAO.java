package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;

public class PersonSqlServerDAO extends DAORelational implements PersonDAO{

	public PersonSqlServerDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(PersonDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDTO> find(PersonDTO budget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PersonDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
