package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import pet.apipet.data.dao.TypePetDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.TypePetDTO;

public class TypePetPostgresDAO extends DAORelational implements TypePetDAO{

	protected TypePetPostgresDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TypePetDTO typepet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TypePetDTO> find(TypePetDTO typepet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TypePetDTO typepet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
