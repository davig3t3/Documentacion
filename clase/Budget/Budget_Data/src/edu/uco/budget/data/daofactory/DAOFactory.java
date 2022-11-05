package edu.uco.budget.data.daofactory;

import javax.management.RuntimeErrorException;

import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.enums.DAOFactoryType;

public abstract class DAOFactory {

	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {
		
		DAOFactory daoFactory;
		
		
		switch (factory) {
		case SQLSERVER:
			daoFactory = new SqlServerDAOFactory();
			break;
		case CASSANDRA:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED);
		case MARIADB:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MONGODB_NOT_IMPLEMENTED);
		case MONGODB:	
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MONGODB_NOT_IMPLEMENTED);
		case MYSQL:
		case ORACLE:
		case POSTGRESQL:
		default:
			throw new RuntimeException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
		}
		return daoFactory;
			
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void confirmTransaction();

	public abstract void cancelTransaction();

	public abstract void closeConnection();

	public abstract BudgetDAO getBudgetDAO();

	public abstract PersonDAO getPersonDAO();

	public abstract YearDAO getYearDAO();
}
