package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.enums.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.data.daofactory.DAOFactory;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase{

	@Override
	public final void execute(final BudgetDTO budget) {
		// TODO Auto-generated method stub
		DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER).getBudgetDAO().create(budget);
		
	}

}
