package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.SpecialCareDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.SpecialCareDTO;

public class SpecialCarePostgresDAO extends DAORelational implements SpecialCareDAO{

	protected SpecialCarePostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(SpecialCareDTO specialcare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SpecialCareDTO> find(SpecialCareDTO specialcare) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SpecialCareDTO specialcare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
