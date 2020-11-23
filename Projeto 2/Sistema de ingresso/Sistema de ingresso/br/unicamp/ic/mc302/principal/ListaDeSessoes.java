package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class ListaDeSessoes<sessao> {

	private ArrayList<sessao> listaDeSessoes = new ArrayList<sessao>();
	
	public void adiciona(sessao ingresso) {
		listaDeSessoes.add(ingresso);
	}
	
	public sessao getSessao(int val) {
		return listaDeSessoes.get(val);
	}
	
	public String mostraSessao(int val) {
		Sessao sessao = (Sessao)listaDeSessoes.get(val);
		return sessao.getHorario();
	}
	
	public int getSize() {
		return listaDeSessoes.size();
	}
}
