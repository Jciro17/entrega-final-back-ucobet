package co.edu.uco.ucobet.generales.domain;

public interface DomainRule<T> {
	void execute(T data);
}
