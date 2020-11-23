package br.unicamp.ic.mc302.principal;

public class IngressoMeia extends Ingresso {
	
	public IngressoMeia(Cliente proprietario, Filme filme, int numeroDaSessao) {
		super(proprietario, filme, numeroDaSessao);
	}
	
	public String getTipo() {
		return "Meia";
	}
}
