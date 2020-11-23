package br.unicamp.ic.mc302.principal;

public class Principal {
	public static void main(String[] args) throws SenhaInvalidaExc {
		Terminal terminal = new Terminal();
		Login login = new Login();
		SistemaDeIngressoFacade facade = new SistemaDeIngressoFacade();
		
		while(true) {
			if (login.iniciar()) {
				facade.setCinema(terminal.iniciarOperacao(facade.getCinema()));
			}
		}
	}

}
