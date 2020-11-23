package br.unicamp.ic.mc302.principal;

public class Carrinho {
	private int qtdIngresso;
	private int tipoPagamento; //se for 1, o tipo de pagamento sera cartao de credito, 2 sera boleto bancario
	private int preco;
	private int quantidadeMeia;
	private int quantidadeInteira;
	
	public Carrinho(int tipoPagamento, int quantidadeMeia, int quantidadeInteira) {
		this.qtdIngresso = quantidadeMeia + quantidadeInteira;
		this.preco = 8 * quantidadeMeia + 16 * quantidadeInteira;
		this.quantidadeInteira = quantidadeInteira;
		this.quantidadeMeia = quantidadeMeia;
	}
	
	public void checkoutCartao() {
		System.out.println("Processando compra...");
		System.out.println("Compra de " + qtdIngresso + " ingressos efetuada");
	}
	
	public void checkoutBoleto() {
		String numBoleto = "23793.38128 60011.765132 30000.533106 1 80420000014351";
		System.out.println("Processando compra...");
		System.out.println("Compra de " + qtdIngresso + " ingressos efetuada");
		System.out.println("Numero do boleto bancario gerado: " + numBoleto);
	}
	
	public void mostraCarrinho(ListaDeIngressos listaDeIngressos, int tipoDePagamento) {
		System.out.println("Carrinho: ");
		listaDeIngressos.mostraIngressos();
		if (tipoDePagamento == 1) {
			System.out.println("Metodo de pagamento: Cartao de credito");
		} else {
			System.out.println("Metodo de pagamento: Boleto bancario");
		}
	}
	
	public int getQtdIngresso() {
		return qtdIngresso;
	}
	
	public int getQtdInteira() {
		return quantidadeInteira;
	}
	public int getQtdMeia() {
		return quantidadeMeia;
	}
	
	public String getMetodoPagamento() {
		if (tipoPagamento == 1) {
			return "Cartao de Credito";
		}
		else {
			return "Boleto Bancario";
		}
	}
	
	public int getPreco() {
		return preco;
	}
	
}
