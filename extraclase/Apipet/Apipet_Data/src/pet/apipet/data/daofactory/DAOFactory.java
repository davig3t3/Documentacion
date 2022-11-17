package pet.apipet.data.daofactory;


import pet.apipet.crosscutting.customException.ApipetCustomException;
import pet.apipet.crosscutting.customException.data.DataCustomException;
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
import pet.apipet.data.enumeration.DAOFactoryType;

public abstract class DAOFactory {
	
	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {
		
		DAOFactory daoFactory;
		
		switch (factory) {
		case POSTGRESQL: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		
		case CASSANDRA: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (ApipetCustomException excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MARIADB: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MONGODB: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MONGDB_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MYSQL: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case ORACLE: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case SQL_SERVER: 
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (ApipetCustomException excetion) {
				throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL, 
						excetion);
			}
			break;
		
		default:
			try {
				daoFactory = new PostgresDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY, 
						excetion);
			}
			break;
		}
		return daoFactory;
	}

	protected abstract void openConnection();

	public abstract void initTransaction();
	
	public abstract void confirmTransaction();
	
	public abstract void cancelTransaction();
		
	public abstract void closeConnection();
	
	public abstract BasicCareDAO getBasicCareDAO();
	
	public abstract BreedDAO getBreedDAO();
	
	public abstract CategoryLocationDAO getCategoryLocationDAO();
	
	public abstract InfoCategoryLocationDAO getInfoCategoryLocationDAO();
	
	public abstract LocationDAO getLocationDAO();
	
	public abstract MapDAO getMapDAO();
	
	public abstract OwnerDAO getOwnerDAO();
	
	public abstract PetDAO getPetDAO();
	
	public abstract SpecialCareDAO getSpecialCareDAO();
	
	public abstract TypePetDAO getTypePetDAO();
	
}

