package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.LocationDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.LocationDTO;

public class LocationPostgresDAO extends DAORelational implements LocationDAO{

	protected LocationPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(LocationDTO location) {
		final var sql = "INSERT INTO location(id_location,coordinates) VALUES (?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, location.getIdAsString());
			preparedStatement.setString(2, location.getCoordinates());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_LOCATION.concat(location.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_LOCATION, exception);
		}
		
	}

	@Override
	public List<LocationDTO> find(LocationDTO location) {
		
		return null;
	}

	@Override
	public void update(LocationDTO location) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
