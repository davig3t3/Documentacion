package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.PetDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.PetDTO;

public class PetPostgresDAO extends DAORelational implements PetDAO{

	protected PetPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(PetDTO pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PetDTO> find(PetDTO pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PetDTO pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
