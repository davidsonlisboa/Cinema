package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class Filme {
	
	private String titulo;
	private ListaDeSessoes listaDeSessoes = new ListaDeSessoes();
	
	public Filme(String titulo) {
		this.titulo = titulo;
		listaDeSessoes.adiciona(new Sessao("14:00"));
		listaDeSessoes.adiciona(new Sessao("20:00"));
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void mostraSessoes() {
		for (int i=0; i<listaDeSessoes.getSize(); i++) {
			System.out.println(i+1 + " - " + listaDeSessoes.getSessao(i));
		}
	}
	
	public int getNumeroDeLugaresFaltantes(Sessao sessao) {
		return sessao.getNumeroDeLugaresFaltantes();
	}
	
	public void ocupaLugar(int quantidadeDeLugaresOcupados, Sessao sessao) {
		sessao.ocupaLugar(quantidadeDeLugaresOcupados);
	}
	
	public Sessao getSessao(int val) {
		return (Sessao)listaDeSessoes.getSessao(val);
	} 
}
