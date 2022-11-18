package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.BasicCareDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.BasicCareDTO;

public class BasicCarePostgresDAO extends DAORelational implements BasicCareDAO {

	protected BasicCarePostgresDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(BasicCareDTO basiccare) {
		final var sql = "INSERT INTO basiscare(id_care,name,date) VALUES (?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, basiccare.getIdAsString());
			preparedStatement.setString(2, basiccare.getName());
			preparedStatement.setShort(3, basiccare.getDate());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_BASICCARE.concat(basiccare.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BASICCARE, exception);
		}

		
	}

	@Override
	public List<BasicCareDTO> find(BasicCareDTO basiccare) {
		return null;
	}

	@Override
	public void update(BasicCareDTO basiccare) {
		
	}

	@Override
	public void delete(UUID id) { 
		
	}

}
