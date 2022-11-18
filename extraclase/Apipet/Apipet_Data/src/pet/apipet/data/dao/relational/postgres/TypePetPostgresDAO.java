package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.TypePetDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.TypePetDTO;

public class TypePetPostgresDAO extends DAORelational implements TypePetDAO{

	protected TypePetPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(TypePetDTO typepet) {
		final var sql = "INSERT INTO typepet(id,nameTypePet) VALUES (?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, typepet.getIdAsString());
			preparedStatement.setString(2, typepet.getNameTypePet());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_TYPE_PET.concat(typepet.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_TYPE_PET, exception);
		}
		
	}

	@Override
	public List<TypePetDTO> find(TypePetDTO typepet) {
		
		return null;
	}

	@Override
	public void update(TypePetDTO typepet) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
