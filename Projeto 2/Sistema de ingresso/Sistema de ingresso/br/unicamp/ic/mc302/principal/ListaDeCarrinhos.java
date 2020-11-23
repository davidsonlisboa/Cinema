package br.unicamp.ic.mc302.principal;

import java.util.ArrayList;

public class ListaDeCarrinhos<carrinho> {

	private ArrayList<carrinho> listaDeCarrinho = new ArrayList<carrinho>();
	
	public void adiciona(carrinho carrinho) {
		listaDeCarrinho.add(carrinho);
	}
	
	
	public void mostraIngressos() {
		int i = 1;
		// Mostra todos os itens disponiveis na biblioteca
		for (carrinho item: listaDeCarrinho) {
			if (item instanceof Ingresso) {
				Ingresso ingressoDaLista = (Ingresso)item;
				System.out.println("Ingresso " + i + " - Tipo: " + ingressoDaLista.getTipo() + 
								   " - Sessao: " + ingressoDaLista.getSessao() +  " - Proprietario: " + 
								   ingressoDaLista.getProprietario());
				}
			i++;
		}
	}
		
	public carrinho getCarrinho(int val) {
		return listaDeCarrinho.get(val);
	}
	
	public int getSize() {
		return listaDeCarrinho.size();
	}
	
	public void esvaziaArray() {
			listaDeCarrinho.clear();
	}
	
	public void mostraCarrinhos() {
		
		if (listaDeCarrinho.size() == 0) {
			System.out.println("Nao ha pedidos passados ):");
		}
		
		int i = 1;
		// Mostra todos os itens disponiveis na biblioteca
		for (carrinho item: listaDeCarrinho) {
			if (item instanceof Carrinho) {
				Carrinho carrinhoDaLista = (Carrinho)item;
				System.out.println("Carrinho " + i + ": Quantidade total de ingressos: " + 
									carrinhoDaLista.getQtdIngresso() + " Quantidade de Meia Entrada: " + 
									carrinhoDaLista.getQtdMeia() + " Quantidade de Entradas Inteiras: " + 
									carrinhoDaLista.getQtdInteira() +" Metodo de pagamento: " + carrinhoDaLista.getMetodoPagamento() + 
									" Valor total: R$" + carrinhoDaLista.getPreco());
				}
			i++;
		}
	}
}