package pet.apipet.crosscutting.helper;

import java.sql.Connection;
import java.sql.SQLException;
import pet.apipet.crosscutting.customException.crosscutting.CrosscuttingCustomException;
import pet.apipet.crosscutting.messages.Messages;

public final class SqlConnectionHelper {

	private SqlConnectionHelper() {
		super();
	}

	public static final boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
	}

	public static final boolean connectionIsOpen(final Connection connection) {
		try {
			return !connectionIsNull(connection) && !connection.isClosed();
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException
					.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL, exception);
		}
	}

	public static final void closeConnection(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException
						.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_ALREADY_IS_CLOSED);
			}
			connection.close();
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(
					Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_CLOSING_CONNECTION, exception);
		} catch (final CrosscuttingCustomException exception) {
			throw exception;
		}
	}

	public static final void initTransation(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(
						Messages.SqlConnectionHelper.TECHNICAL_CONNETION_IS_CLOSED_FOR_INIT_TRANSACTION);
			}

			connection.setAutoCommit(false);
		} catch (CrosscuttingCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(
					Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION, exception);
		}
	}

	public static final void commitTransation(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(
						Messages.SqlConnectionHelper.TECHNICAL_CONNETION_IS_CLOSED_FOR_COMMIT_TRANSACTION);
			}

			connection.setAutoCommit(false);
		} catch (CrosscuttingCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(
					Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION, exception);
		}
	}

	public static final void rollbackTransation(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				throw CrosscuttingCustomException.createTechnicalException(
						Messages.SqlConnectionHelper.TECHNICAL_CONNETION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION);
			}

			connection.setAutoCommit(false);
		} catch (CrosscuttingCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw CrosscuttingCustomException.createTechnicalException(
					Messages.SqlConnectionHelper.TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION, exception);
		}
	}

}
