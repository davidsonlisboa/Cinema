package br.unicamp.ic.mc302.principal;

public class Fabrica {
	
	public final static IngressoMeia criaIngressoMeia(Cliente proprietario, Filme filme, int numeroDaSessao) {

		return new IngressoMeia(proprietario, filme, numeroDaSessao);
	}
	
	public final static IngressoInteira criaIngressoInteira(Cliente proprietario, Filme filme, int numeroDaSessao) {

		return new IngressoInteira(proprietario, filme, numeroDaSessao);
	}

}
