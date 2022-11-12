package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.BreedDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.BreedDTO;

public class BreedPostgresDAO extends DAORelational implements BreedDAO{

	protected BreedPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(BreedDTO breed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BreedDTO> find(BreedDTO breed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BreedDTO breed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
