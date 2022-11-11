package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.InfoCategoryLocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.InfoCategoryLocationDTO;

public class InfoCategoryLocationPostgresDAO extends DAORelational implements InfoCategoryLocationDAO{

	protected InfoCategoryLocationPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(InfoCategoryLocationDTO infocategorylocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InfoCategoryLocationDTO> find(InfoCategoryLocationDTO infocategorylocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InfoCategoryLocationDTO infocategorylocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
