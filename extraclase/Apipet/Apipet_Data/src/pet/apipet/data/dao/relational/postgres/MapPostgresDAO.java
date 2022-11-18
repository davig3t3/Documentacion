package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.MapDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.MapDTO;
import pet.apipet.domain.builder.MapDTOBuilder;

public class MapPostgresDAO extends DAORelational implements MapDAO{

	protected MapPostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(MapDTO map) {
		final var sql = "INSERT INTO map(id,cityName) VALUES (?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, map.getIdAsString());
			preparedStatement.setString(2, map.getCityName());
			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_MAP.concat(map.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_MAP, exception);
		}
		
	}

	@Override
	public List<MapDTO> find(MapDTO map) {
		
		return null;
	}

	@Override
	public void update(MapDTO map) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
