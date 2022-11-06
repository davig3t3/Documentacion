package edu.uco.budget.service.usecase.budget.implementation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.person.FindPersonById;
import edu.uco.budget.service.usecase.person.implementation.FindPersonByIdImpl;
import edu.uco.budget.service.usecase.year.FindNextYearUseCase;
import edu.uco.budget.service.usecase.year.implementation.FindNextYearUseCaseImpl;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {
	
	private final DAOFactory factory;
	private final FindNextYearUseCase findNextYearUseCase;
	private final FindPersonById findPersonById;

	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findNextYearUseCase = new FindNextYearUseCaseImpl(factory);
		findPersonById = new FindPersonByIdImpl(factory);
	}
	
	@Override
	public final void execute(BudgetDTO budget) {
		//1. Que el año de presupuesto exista
		final YearDTO year = findNextYearUseCase.execute();
		
		//2. Que la persona exista
		final PersonDTO person = findPersonById.execute(budget.getPerson().getId());
		
		if(person.notExist()) {
		//	throw ServiceCusto
		}
			
			
		//3.Que no existe un presupuesto para el mismo usuario en el mismo año
		//4.Crear el presupuesto.
		
		
		
		
		
		factory.getBudgetDAO().create(budget);
	}
	
	
	

}
