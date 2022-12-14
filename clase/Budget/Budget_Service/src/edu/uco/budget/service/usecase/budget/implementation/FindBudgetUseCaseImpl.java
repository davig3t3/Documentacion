package edu.uco.budget.service.usecase.budget.implementation;

import java.util.List;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.FindBudgetUseCase;
import edu.uco.budget.service.usecase.person.FindPersonById;
import edu.uco.budget.service.usecase.person.implementation.FindPersonByIdImpl;
import edu.uco.budget.service.usecase.year.FindNextYearUseCase;
import edu.uco.budget.service.usecase.year.implementation.FindNextYearUseCaseImpl;

public class FindBudgetUseCaseImpl implements FindBudgetUseCase {
	
	private final DAOFactory factory;
	

	public FindBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public List<BudgetDTO> execute(BudgetDTO budget) {
		
		return factory.getBudgetDAO().find(budget);
	}
	

}
