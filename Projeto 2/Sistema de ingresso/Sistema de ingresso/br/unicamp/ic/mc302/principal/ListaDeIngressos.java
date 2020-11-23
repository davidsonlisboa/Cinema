package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class ListaDeIngressos<ingresso> {

	private ArrayList<ingresso> listaDeIngresso = new ArrayList<ingresso>();
	
	public void adiciona(ingresso ingresso) {
		listaDeIngresso.add(ingresso);
	}
	
	public void removeIngresso(String nome) {
		for(int i=0; i<listaDeIngresso.size(); i++) {
			Ingresso ing = (Ingresso) listaDeIngresso.get(i);
			String prop = ing.getProprietario();
			if (prop.equals(nome)) {
				listaDeIngresso.remove(i);
				break;
			}
		}
	}
	
	
	public void mostraIngressos() {
		int i = 1;
		// Mostra todos os itens disponiveis na biblioteca
		for (ingresso item: listaDeIngresso) {
			if (item instanceof Ingresso) {
				Ingresso ingressoDaLista = (Ingresso)item;
				System.out.println("Ingresso " + i + " - Tipo: " + ingressoDaLista.getTipo() + 
								   " - Sessao: " + ingressoDaLista.getSessao() +  " - Proprietario: " + 
								   ingressoDaLista.getProprietario());
			}
			i++;
		}
	}
	
	public ingresso getIngresso(int val) {
		return listaDeIngresso.get(val);
	}
	
	public int getSize() {
		return listaDeIngresso.size();
	}
	
	public void esvaziaArray() {
			listaDeIngresso.clear();
	}
}
