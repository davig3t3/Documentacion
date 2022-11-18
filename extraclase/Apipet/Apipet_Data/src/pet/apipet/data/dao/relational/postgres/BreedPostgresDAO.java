package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.BreedDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.BreedDTO;

public class BreedPostgresDAO extends DAORelational implements BreedDAO{

	protected BreedPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(BreedDTO breed) {
		final var sql = "INSERT INTO breed(id_breed,name,origin,description,temper,colors,height,weight) VALUES (?,?,?,?,?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, breed.getIdAsString());
			preparedStatement.setString(2, breed.getName());
			preparedStatement.setString(3, breed.getOrigin());
			preparedStatement.setString(4, breed.getDescription());
			preparedStatement.setString(5, breed.getTemper());
			preparedStatement.setString(6, breed.getColors());
			preparedStatement.setFloat(7, breed.getHeight());
			preparedStatement.setFloat(8, breed.getWeight());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_BREED.concat(breed.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BREED, exception);
		}
		
	}

	@Override
	public List<BreedDTO> find(BreedDTO breed) {
		
		return null;
	}

	@Override
	public void update(BreedDTO breed) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
