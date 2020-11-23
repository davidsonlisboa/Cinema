package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class Cinema {

	private String nome;
	private String local;
	private int quantidadeDeSalas;
	private ArrayList listaDeFilmes = new ArrayList();
	
	public Cinema(String nome, String local, int quantidadeDeSalas,
				  Filme filme1, Filme filme2) {
		this.nome = nome;
		this.local = local;
		this.quantidadeDeSalas = quantidadeDeSalas;
		this.listaDeFilmes.add(filme1);
		this.listaDeFilmes.add(filme2);
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidadeDeSalas() {
		return quantidadeDeSalas;
	}
	
	public ArrayList getListaDeFilmes() {
		return listaDeFilmes;
	}
	
	public void mostraFilmes() {
		for (int i=0; i<listaDeFilmes.size(); i++) {
			final Filme filme = (Filme)listaDeFilmes.get(i);
			System.out.println(i+1 + " - " + filme.getTitulo());
		}
	}
}
