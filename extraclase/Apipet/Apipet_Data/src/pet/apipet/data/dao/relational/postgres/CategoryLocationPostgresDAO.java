package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.CategoryLocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.CategoryLocationDTO;

public class CategoryLocationPostgresDAO extends DAORelational implements CategoryLocationDAO{

	protected CategoryLocationPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(CategoryLocationDTO categorylocation) {
		final var sql = "INSERT INTO categorylocation(id_categoryLocation,category) VALUES (?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, categorylocation.getIdAsString());
			preparedStatement.setString(2, categorylocation.getCategory());
			preparedStatement.executeUpdate();
			

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_CATEGORYLOCATION.concat(categorylocation.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_CATEGORYLOCATION, exception);
		}
		
	}

	@Override
	public List<CategoryLocationDTO> find(CategoryLocationDTO categorylocation) {
		
		return null;
	}

	@Override
	public void update(CategoryLocationDTO categorylocation) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
