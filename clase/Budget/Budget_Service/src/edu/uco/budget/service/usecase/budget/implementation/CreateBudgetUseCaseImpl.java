package edu.uco.budget.service.usecase.budget.implementation;

import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.customException.service.ServiceCustomException;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.budget.FindBudgetUseCase;
import edu.uco.budget.service.usecase.person.FindPersonById;
import edu.uco.budget.service.usecase.person.implementation.FindPersonByIdImpl;
import edu.uco.budget.service.usecase.year.FindNextYearUseCase;
import edu.uco.budget.service.usecase.year.implementation.FindNextYearUseCaseImpl;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {
	
	private final DAOFactory factory;
	private final FindNextYearUseCase findNextYearUseCase;
	private final FindPersonById findPersonById;
	private final FindBudgetUseCase findBudgetUseCase;

	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
		findNextYearUseCase = new FindNextYearUseCaseImpl(factory);
		findPersonById = new FindPersonByIdImpl(factory);
		findBudgetUseCase = new FindBudgetUseCaseImpl(factory);
	}
	
	@Override
	public final void execute(BudgetDTO budget) {
		
		final YearDTO year = findNextYearUseCase.execute();
		final PersonDTO person = findPerson(budget.getPerson().getId());
		
		
		budget.setYear(year);
		budget.setPerson(person);
		validateIfBudgetExist(budget);
		
		budget.setId(UUIDHelper.getNewUUID());
		
		factory.getBudgetDAO().create(budget);
	}
	
	private final PersonDTO findPerson(final UUID id) {
				final PersonDTO person = findPersonById.execute(id);
				
				if(person.notExist()) {
					throw ServiceCustomException.createUserException(Messages.CreateBudgetUseCaseImpl.BUSINESS_PERSON_DOES_NOT_EXIST);
				}
				return person;
	}
	
	private final void validateIfBudgetExist(BudgetDTO budget) {
		
		if(!findBudgetUseCase.execute(budget).isEmpty()) {
			throw ServiceCustomException.createUserException(Messages.CreateBudgetUseCaseImpl.BUSINESS_BUDGET_EXIST);
		}
	}
	

}
