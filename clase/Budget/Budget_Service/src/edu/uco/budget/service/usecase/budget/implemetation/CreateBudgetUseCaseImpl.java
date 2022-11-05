package edu.uco.budget.service.usecase.budget.implemetation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {
	
	private final DAOFactory factory;

	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public final void execute(BudgetDTO budget) {
		//1. que el año de presupuesto exista
		//2.que la persona exista
		//3.que no existe un presupuesto para el mismo usuario en el mismo año
		
		
	
		
		//4. Crear  el presupuesto
		
		factory.getBudgetDAO().create(budget);
	}
	
	
	
	
}
