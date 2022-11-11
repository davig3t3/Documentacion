package pet.apipet.data.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import pet.apipet.crosscutting.customException.crosscutting.CrosscuttingCustomException;
import pet.apipet.crosscutting.customException.data.DataCustomException;
import pet.apipet.crosscutting.helper.SqlConnectionHelper;
import pet.apipet.crosscutting.messages.Messages;
import pet.apipet.data.dao.BasicCareDAO;
import pet.apipet.data.dao.BreedDAO;
import pet.apipet.data.dao.CategoryLocationDAO;
import pet.apipet.data.dao.InfoCategoryLocationDAO;
import pet.apipet.data.dao.LocationDAO;
import pet.apipet.data.dao.MapDAO;
import pet.apipet.data.dao.OwnerDAO;
import pet.apipet.data.dao.PetDAO;
import pet.apipet.data.dao.SpecialCareDAO;
import pet.apipet.data.dao.TypePetDAO;

final class PostgresDAOFactory extends DAOFactory {

	private Connection connection;

	PostgresDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		final String url = "peanut.db.elephantsql.com:5432;" + "database=amahqwvq;"
				+ "user=amahqwvq;" + "password=UIvSZbLIEkxHlPLkN6tb9X4DT9phSI2a;" + "encrypt=true;" + "trustServerCertificate=false;"
				+ "hostNameInCertificate=*.database.windows.net;" + "loginTimeout=30;";
		try {
			connection = DriverManager.getConnection(url);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED,
					exception);
		}
	}

	@Override
	public void initTransaction() {
		try {
			SqlConnectionHelper.initTransation(connection);
		} catch (CrosscuttingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlServerDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		try {
			SqlConnectionHelper.commitTransation(connection);
		} catch (Exception exception) {

		}
	}

	@Override
	public void cancelTransaction() {
		try {
		SqlConnectionHelper.rollbackTransation(connection);
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}

	@Override
	public void closeConnection() {
		try {
		SqlConnectionHelper.closeConnection(connection);
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}

	@Override
	public BasicCareDAO getBasicCareDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreedDAO getBreedDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryLocationDAO getCategoryLocationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoCategoryLocationDAO getInfoCategoryLocationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationDAO getLocationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapDAO getMapDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OwnerDAO getOwnerDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PetDAO getPetDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialCareDAO getSpecialCareDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypePetDAO getTypePetDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
