package pet.apipet.data.dao.relational;

import java.sql.Connection;

import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.helper.SqlConnectionHelper;
import pet.apipet.crosscutting.messages.Messages;

public class DAORelational {

	private Connection connection;

	protected DAORelational(final Connection connection) {

		if (!SqlConnectionHelper.connectionIsNull(connection)) {
			throw DataCustomException
					.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED);
		}

		this.connection = connection;

	}

	protected final Connection getConnection() {
		return connection;
	}

}
