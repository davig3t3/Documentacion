package pet.apipet.data.dao.relational.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.helper.ObjectHelper;
import pet.apipet.crosscutting.helper.UUIDHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.OwnerDAO;
import pet.apipet.data.dao.relational.DAORelational;
import pet.apipet.domain.MapDTO;
import pet.apipet.domain.OwnerDTO;

public class OwnerPostgresDAO extends DAORelational implements OwnerDAO {

	public OwnerPostgresDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(OwnerDTO owner) {
		final var sql = "INSERT INTO dueno(id,nameowner,email,phonenumber,address,password,birthdate) VALUES (?,?,?,?,?,?,?)";

		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, owner.getIdAsString());
			preparedStatement.setString(2, owner.getNameOwner());
			preparedStatement.setString(3, owner.getEmail());
			preparedStatement.setString(4, owner.getPhoneNumber());
			preparedStatement.setString(5, owner.getAddress());
			preparedStatement.setString(6, owner.getPassword());
			preparedStatement.setShort(7, owner.getBirthDate());

			preparedStatement.executeUpdate();

		} catch (final SQLException exception) {
			String message = Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_CREATE_OWNER.concat(owner.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_OWNER, exception);
		}

	}

	@Override
	public List<OwnerDTO> find(OwnerDTO owner) {
		var sqlBuilder = new StringBuilder();
		final var parameters = new ArrayList<Object>();

	//	createSelectFrom(sqlBuilder);
		// createWhere(sqlBuilder, owner, parameters);
		// createOrderBy(sqlBuilder);

		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}

	private final List<OwnerDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())) {

			setParameterValues(preparedStatement, parameters);

			return executeQuery(preparedStatement);

		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_PREPARED_STAMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		}
	}

	/*private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT      d.id_dueno AS IdDueno,");
		sqlBuilder.append("            d.nombre AS NombreDueno,");
		sqlBuilder.append("            d.correo AS Correo");
		sqlBuilder.append("            d.contrasena AS Contrasena,");
		sqlBuilder.append("            d.telefono AS Telefono,");
		sqlBuilder.append("            d.direccion AS direccion,");
		sqlBuilder.append("            d.fecha_nacimiento AS FechaNacimiento,");
		sqlBuilder.append("            m.id_mapa AS IdMapa,");
		sqlBuilder.append("FROM        dueno d");
		sqlBuilder.append("INNER JOIN  mapa m");
		sqlBuilder.append("ON          d.idDueno = m.id");
	}*/

	private final List<OwnerDTO> executeQuery(PreparedStatement preparedStatement) {
		try (final var resultset = preparedStatement.executeQuery()) {
			return fillResults(resultset);
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECEUTE_QUERY, exception);
		}
	}

	private void setParameterValues(PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		}
	}

	private final List<OwnerDTO> fillResults(final ResultSet resultset) {

		try {
			var results = new ArrayList<OwnerDTO>();

			while (resultset.next()) {
				results.add(fillOwnerDTO(resultset));
			}

			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.ApipetPostgreSQLDAO.TECHNICAL_PROBLEM_FILL_RESULTS, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.ApipetPostgreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS, exception);
		}

	}

	private final OwnerDTO fillOwnerDTO(final ResultSet resultset) {
		/*try {

			return OwnerDTO.create(resultset.getString("idOwner"), fillMapDTO(resultset));

		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.OwnerPostegreSQLDAO.TECHNICAL_PROBLEM_FILL_OWNER_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.OwnerPostegreSQLDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_OWNER_DTO, exception);
		}*/
		return null;
	}

	private final MapDTO fillMapDTO(final ResultSet resultSet) {
		/*try {
			return MapDTO.create(null, null);
		} catch (final SQLException exception) {
			throw DataCustomException
					.createTechnicalException(Messages.OwnerPostegreSQLDAO.TECHNICAL_PROBLEM_FILL_YEAR_DTO, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(
					Messages.OwnerPostegreSQLDAO, exception);
		}*/
		return null;
	}


	@Override
	public void update(OwnerDTO owner) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub

	}

}
