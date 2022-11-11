package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.MapDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.builder.MapDTOBuilder;

public class MapPostgresDAO extends DAORelational implements MapDAO{

	protected MapPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(MapDTOBuilder map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MapDTOBuilder> find(MapDTOBuilder map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MapDTOBuilder map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
