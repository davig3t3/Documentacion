package edu.uco.budget.service.usecase.year.implemetation;

import java.util.List;

import edu.uco.budget.crosscutting.helper.DateHelper;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.YearDTO;
import edu.uco.budget.service.usecase.year.FindNextYearUseCase;

public class FindNextYearUseCaseImpl implements FindNextYearUseCase {
	
	private final DAOFactory factory;

	public FindNextYearUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public YearDTO execute() {
		YearDTO year = YearDTO.create("", DateHelper.getNextYear());
		List<YearDTO> result = factory.getYearDAO().find(year);
		
		
		
		return null;
	}

}
