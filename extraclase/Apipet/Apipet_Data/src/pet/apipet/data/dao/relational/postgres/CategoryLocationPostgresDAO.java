package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.CategoryLocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.CategoryLocationDTO;

public class CategoryLocationPostgresDAO extends DAORelational implements CategoryLocationDAO{

	protected CategoryLocationPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(CategoryLocationDTO categorylocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryLocationDTO> find(CategoryLocationDTO categorylocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoryLocationDTO categorylocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
