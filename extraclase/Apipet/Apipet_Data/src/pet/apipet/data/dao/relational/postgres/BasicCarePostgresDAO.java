package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.BasicCareDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.BasicCareDTO;

public class BasicCarePostgresDAO extends DAORelational implements BasicCareDAO {

	protected BasicCarePostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(BasicCareDTO basiccare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BasicCareDTO> find(BasicCareDTO basiccare) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BasicCareDTO basiccare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
