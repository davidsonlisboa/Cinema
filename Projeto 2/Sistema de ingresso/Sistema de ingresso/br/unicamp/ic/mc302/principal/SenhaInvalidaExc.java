package br.unicamp.ic.mc302.principal;

public class SenhaInvalidaExc extends Exception {
	private String attr;
	
	public SenhaInvalidaExc(String nome) {
		super(nome);
		this.attr = nome;
	}
	
}