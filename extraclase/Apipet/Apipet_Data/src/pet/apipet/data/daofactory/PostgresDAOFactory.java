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
import pet.apipet.data.dao.relational.postgres.OwnerPostgresDAO;

public final class PostgresDAOFactory extends DAOFactory {

	private Connection connection;

	public PostgresDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		/*final String url = "jdbc:postgresql://localhost:5432/doo";
		final String user = "postgres";
		final String password = "root";
		
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED,
					exception);
		}*/
		final String url = "peanut.db.elephantsql.com:5432" + "database=amahqwvq"
                + "user=amahqwvq" + "password=UIvSZbLIEkxHlPLkN6tb9X4DT9phSI2a";
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
			throw DataCustomException.createTechnicalException(Messages.PostgresDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
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
		return new OwnerPostgresDAO(connection);
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
