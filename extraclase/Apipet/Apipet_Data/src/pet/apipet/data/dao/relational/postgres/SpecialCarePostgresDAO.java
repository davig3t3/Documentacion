package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.SpecialCareDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.SpecialCareDTO;

public class SpecialCarePostgresDAO extends DAORelational implements SpecialCareDAO{

	protected SpecialCarePostgresDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(SpecialCareDTO specialcare) {
		final var sql = "INSERT INTO specialcare(id,nameCare,descriptionCare,dateUltimateCare) VALUES (?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, specialcare.getIdAsString());
			preparedStatement.setString(2, specialcare.getNameCare());
			preparedStatement.setString(2, specialcare.getNameDescriptionCare());
			preparedStatement.setShort(3, specialcare.getDateUltimateCare());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_SPECIAL_CARE.concat(specialcare.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_SPECIAL_CARE, exception);
		}
		
	}

	@Override
	public List<SpecialCareDTO> find(SpecialCareDTO specialcare) {
		
		return null;
	}

	@Override
	public void update(SpecialCareDTO specialcare) {
		
		
	}

	@Override
	public void delete(UUID id) {
		
		
	}

}
