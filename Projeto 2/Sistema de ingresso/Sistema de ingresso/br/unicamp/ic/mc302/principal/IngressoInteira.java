package br.unicamp.ic.mc302.principal;

public class IngressoInteira extends Ingresso {

	public IngressoInteira(Cliente proprietario, Filme filme, int numeroDaSessao) {
		super(proprietario, filme, numeroDaSessao);
	}
	
	public String getTipo() {
		return "Inteira";
	}
}
