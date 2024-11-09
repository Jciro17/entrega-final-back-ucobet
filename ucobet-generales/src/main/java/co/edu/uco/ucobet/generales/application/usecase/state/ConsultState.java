package co.edu.uco.ucobet.generales.application.usecase.state;

import java.util.List;

import co.edu.uco.ucobet.generales.application.usecase.UsecaseWithReturn;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public interface ConsultState extends UsecaseWithReturn< List<StateDomain>,StateDomain> {

}
