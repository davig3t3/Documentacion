package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.PetDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.PetDTO;

public class PetPostgresDAO extends DAORelational implements PetDAO{

	protected PetPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(PetDTO pet) {
		final var sql = "INSERT INTO pet(id,namePet,birthDatee) VALUES (?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, pet.getIdAsString());
			preparedStatement.setString(2, pet.getNamePet());
			preparedStatement.setShort(3, pet.getBirthDate());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_PET.concat(pet.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_PET, exception);
		}
		
	}

	@Override
	public List<PetDTO> find(PetDTO pet) {
		
		return null;
	}

	@Override
	public void update(PetDTO pet) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
