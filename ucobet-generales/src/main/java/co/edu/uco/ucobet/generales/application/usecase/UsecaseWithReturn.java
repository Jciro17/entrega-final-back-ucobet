package co.edu.uco.ucobet.generales.application.usecase;

public interface UsecaseWithReturn<R,D> {
	
	
	R execute(D data);
	
	

}
