package br.unicamp.ic.mc302.principal;

public class SistemaDeIngressoFacade {

	Filme theJoker = new Filme("The Joker");
	Filme avengers = new Filme("Avengers");
	Cinema kinoplex = new Cinema("Kinoplex", "Shopping Dom Pedro", 1, theJoker, avengers);
	
	public Cinema getCinema() {
		return kinoplex;
	}
	
	public void setCinema(Cinema cinema) {
		this.kinoplex = cinema;
	}

}
