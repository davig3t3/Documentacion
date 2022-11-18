package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.InfoCategoryLocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.InfoCategoryLocationDTO;

public class InfoCategoryLocationPostgresDAO extends DAORelational implements InfoCategoryLocationDAO{

	protected InfoCategoryLocationPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(InfoCategoryLocationDTO infocategorylocation) {
		final var sql = "INSERT INTO infocategorylocation(id_InfoCategoryLocation,name,description,schedule,phoneNumber) VALUES (?,?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, infocategorylocation.getIdAsString());
			preparedStatement.setString(2, infocategorylocation.getName());
			preparedStatement.setString(3, infocategorylocation.getDescription());
			preparedStatement.setShort(4, infocategorylocation.getSchedule());
			preparedStatement.setString(5, infocategorylocation.getPhoneNumber());
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_INFOCATEGORYLOCATION.concat(infocategorylocation.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_INFOCATEGORYLOCATION, exception);
		}
		
	}

	@Override
	public List<InfoCategoryLocationDTO> find(InfoCategoryLocationDTO infocategorylocation) {
		
		return null;
	}

	@Override
	public void update(InfoCategoryLocationDTO infocategorylocation) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
