package br.unicamp.ic.mc302.principal;

public class EstadoNormal extends EstadoDeSessao {
	
	public void estadoDaSessao() {
		// Como o usuario nao precisa receber
		// nenhuma mensagem caso o estado esteja normal,
		// faremos apenas um print vazio
		System.out.print("");
	}
}
