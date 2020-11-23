package br.unicamp.ic.mc302.principal;

public class Ingresso {
	private Filme filme;
	private String sala;
	private String sessao;
	private Cliente proprietario;

	public Ingresso(Cliente proprietario, Filme filme, int numeroDaSessao) {
		this.proprietario = proprietario;
		this.filme = filme;
		this.sala = "A"; // Temos apenas uma sala
		if (numeroDaSessao == 1) {
			this.sessao = "14:00h";
		} else {
			this.sessao = "20:00h";
		}
	}
	
	public String getProprietario() {
		return proprietario.getNome();
	}
	
	public String getSessao() {
		return sessao;
	}
	
	public String getTipo() {
		return "Ingresso";
	}
}
