package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.LocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.LocationDTO;

public class LocationPostgresDAO extends DAORelational implements LocationDAO{

	protected LocationPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(LocationDTO location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocationDTO> find(LocationDTO location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LocationDTO location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
