package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class ListaDeCinemas<cinema> {
	private ArrayList<cinema> listaDeCinemas = new ArrayList<cinema>();
	
	public void adiciona(cinema cinema) {
		listaDeCinemas.add(cinema);
	}
	
	
	public void mostraCinemas() {
		int i = 1;
		// Mostra todos os itens disponiveis na biblioteca
		for (cinema item: listaDeCinemas) {
			if (item instanceof Cinema) {
				Cinema cinemaDaLista = (Cinema)item;
				System.out.println("Cinema " + i + " : " + cinemaDaLista.getNome());
			}
			i++;
		}
	}
	
	public cinema getItem(int val) {
		return listaDeCinemas.get(val);
	}
	
	public int getSize() {
		return listaDeCinemas.size();
	}
}
