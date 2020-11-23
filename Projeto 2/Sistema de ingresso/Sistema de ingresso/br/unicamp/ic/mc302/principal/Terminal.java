package br.unicamp.ic.mc302.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {
	private int numeroDoFilme;
	private int numeroDaSessao;
	private Sessao sessaoEscolhida;
	private int quantidadeDeInteiras;
	private int quantidadeDeMeiaEntrada;
	private String numeroDoCartao;
	private String nomeDoCartao;
	private String validadeDoCartao;
	private String chaveDeSegurancaDoCartao;
	private int flagMeiaEntrada;
	private int flagEntradaInteira;
	private ArrayList listaDeFilmes = new ArrayList();
	private Filme filmeEscolhido;
	private int formaDePag;
	private String entradaDeNome;
	private String[] nomeDoUsuario;
	private ListaDeIngressos listaDeIngressos = new ListaDeIngressos();
	private ListaDeCarrinhos listaDeCarrinhos = new ListaDeCarrinhos();
	private int confirmacao;
	private int escolha;
	private Scanner scanner = new Scanner(System.in); 
	
	public Cinema iniciarOperacao(Cinema cinema) {
	
		System.out.println("Digite:");
		System.out.println("1 - Para escolher uma sessao");
		System.out.println("2 - Para ver os pedidos anteriores antes de escolher uma sessao: ");
		
		try {
			escolha = scanner.nextInt();
		} catch (Exception e) {
			
		}
		
		if (escolha == 2) {
			listaDeCarrinhos.mostraCarrinhos();
		}
		
		cinema.mostraFilmes();
		listaDeFilmes = cinema.getListaDeFilmes();
		
		numeroDoFilme = getInt("");
		
		estilo();
		System.out.println("Digite o numero da sessao desejada: ");
		
		// Fazendo o casting para acessar as sessoes 
		// disponiveis para o filme
		filmeEscolhido = (Filme)listaDeFilmes.get(numeroDoFilme-1);
		System.out.println("1 - 14:00h");
		System.out.println("2 - 20:00h");
		numeroDaSessao = getInt("");
		sessaoEscolhida = filmeEscolhido.getSessao(numeroDaSessao-1); // Consertando o index da array
		estilo();
		while (sessaoEscolhida.getNumeroDeLugaresFaltantes() == 0) {
			System.out.println("1 - 14:00h");
			System.out.println("2 - 20:00h");
			numeroDaSessao = getInt("");
			sessaoEscolhida = filmeEscolhido.getSessao(numeroDaSessao-1); // Consertando o index da array
			estilo();
		}

		leIngressos(cinema);
		
		System.out.println("Digite a forma de pagamento");
		System.out.println("1 - Cartao de credito");
		System.out.println("2 - Boleto bancario");
		formaDePag = getInt("");
		estilo();
		
		Carrinho carrinho = new Carrinho(formaDePag, quantidadeDeInteiras, quantidadeDeMeiaEntrada);
		
		carrinho.mostraCarrinho(listaDeIngressos, formaDePag);
		
		estilo();
		
		// Confirmacao de compra
		System.out.println("Deseja confirmar sua compra?");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		confirmacao = getInt("");
		confirmacao(confirmacao, carrinho);
		estilo();

		resetaSistema();
		
		return cinema;
	}
	
	private void confirmacao(int confirmacao, Carrinho carrinho) {
		if (confirmacao == 1) {
			if (formaDePag == 1) {
				cartaoSelecionado(carrinho);
			} else {
				// Gerando os dados do boleto
				carrinho.checkoutBoleto();
			}
			
			listaDeCarrinhos.adiciona(carrinho);
			System.out.println("Bom filme!");
			estilo();
		} else {
			System.out.println("Deseja remover algum ingresso?");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao. Quero cancelar a compra");
			int flag = getInt("");
			
			if (flag==1) {
				System.out.println("Digite o nome do portador do ingresso que deseja remover: ");
				String string = getString();
				try {
					listaDeIngressos.removeIngresso(string);
					sessaoEscolhida.desocupaLugar(1);
				}
				catch (Exception e) {
					System.out.println("Erro");
				}
				carrinho.mostraCarrinho(listaDeIngressos, formaDePag);
				
				System.out.println("Deseja confirmar sua compra?");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				
				confirmacao = getInt("");
				confirmacao(confirmacao, carrinho);
			} else {
				sessaoEscolhida.desocupaLugar(quantidadeDeMeiaEntrada+quantidadeDeInteiras);	
			}
		}
	}

	private void cartaoSelecionado(Carrinho carrinho) {
		// Obtendo dados do cartao de credito
		System.out.println("Digite o numero do cartao de credito.");
		numeroDoCartao = getString();
		estilo();
		System.out.println("Digite o nome que aparece no cartao.");
		nomeDoCartao = getString();
		estilo();
		System.out.println("Digite a data de validade do cartao de credito.");
		validadeDoCartao = getString();
		estilo();
		System.out.println("Digite a chave de seguranca do cartao de credito.");
		chaveDeSegurancaDoCartao = getString();
		estilo();
		carrinho.checkoutCartao();
	}
	
	// Reseta dados do usuario anterior
	private void resetaSistema() {
		sessaoEscolhida.ocupaLugar(quantidadeDeMeiaEntrada + quantidadeDeInteiras);
		quantidadeDeMeiaEntrada = 0;
		quantidadeDeInteiras = 0;
		listaDeIngressos.esvaziaArray();
	}

	private void leIngressos(Cinema cinema) {
		// Le entrada de ingressos
		
		System.out.println("Ha " + sessaoEscolhida.getNumeroDeLugaresFaltantes() + " lugares disponiveis para essa sessao. Deseja comprar meia entrada?");
		System.out.println("1 - Sim");
		System.out.println("2 - Nao");
		flagMeiaEntrada = getInt("");
		estilo();
		
		// Meia entrada
		if (flagMeiaEntrada == 1) {
			System.out.println("Quantos ingressos do tipo meia voce deseja?");
			quantidadeDeMeiaEntrada = getInt("");
			
			// Como temos apenas 3 poltronas na sala o usuario 
			// nao consegue escolher mais do que 3 ingressos
			while (quantidadeDeMeiaEntrada > 3) {
				System.out.println("A quantia digitada eh superior a quantidade de lugares disponiveis... " +
						           "Quantos ingressos do tipo meia deseja comprar?");
				quantidadeDeMeiaEntrada = getInt("");
				estilo();
				
			}
			estilo();
			
			criaIngresso(0);
		}
		
		// Entrada inteira, soh eh possivel acessar entrada inteira
		// caso a quantidade de meia entrada escolhida seja inferior a 3
		if (quantidadeDeMeiaEntrada < 3) {
			System.out.println("Deseja comprar ingressos do tipo inteira?");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			flagEntradaInteira = getInt("");
			estilo();
			// Caso o usuario escolher comprar entrada inteira e
			// nao tenha escolhido nenhuma meia entrada
			if (flagEntradaInteira == 1 && flagMeiaEntrada == 2) {
				System.out.println("Ha " + sessaoEscolhida.getNumeroDeLugaresFaltantes() +" ingressos disponiveis. Quantos ingressos do tipo inteira voce deseja comprar?");
				quantidadeDeInteiras = getInt("");
				estilo();
				while (quantidadeDeInteiras > 3) {
					System.out.println("A quantia digitada eh superior a quantidade de lugares disponiveis... " +
							           "Quantos ingressos deseja comprar?");
					quantidadeDeInteiras = getInt("");
					estilo();
				}
				criaIngresso(1);
			} 
			// Caso o usuario tenha escolhido comprar entrada inteira e
			// jah tenha escolhido meia entrada anteriormente
			else if (flagEntradaInteira == 1 && quantidadeDeMeiaEntrada > 0) {
				System.out.println("Ha " + (3-quantidadeDeMeiaEntrada) + " lugares disponiveis. " +
						           "Quantos ingressos do tipo inteira voce deseja comprar?");
				quantidadeDeInteiras = getInt("");
				estilo();
				while (quantidadeDeInteiras > 3-quantidadeDeMeiaEntrada) {
					System.out.println("A quantia digitada eh superior a quantidade de lugares disponiveis... " +
							           "Quantos ingressos deseja comprar?");
					quantidadeDeInteiras = getInt("");
					estilo();
				}
				criaIngresso(1);
			}
		}
		
		
	}

	private void criaIngresso(int flag) {
		System.out.println("Digite o nomes dos portadores de cada ingresso, seguido de uma vigula. " +
			   		       "Ex: Matheus, Davidson, Giovana");
		entradaDeNome = getString();
		estilo();
		nomeDoUsuario = entradaDeNome.split(", ");
		
		if (flag == 0) { 
		// Instanciando ingressos do tipo meia e
		// associando eles aos clientes
			for (int i=0; i<quantidadeDeMeiaEntrada; i++) {
				Cliente cliente = new Cliente(nomeDoUsuario[i]);
				IngressoMeia ingresso = Fabrica.criaIngressoMeia(cliente, filmeEscolhido, numeroDaSessao);
				listaDeIngressos.adiciona(ingresso);
			}
		} else {
			// Instanciando ingressos do tipo inteira
			// e associando eles aos clientes
			for (int i=0; i<quantidadeDeInteiras; i++) {
				Cliente cliente = new Cliente(nomeDoUsuario[i]);
				IngressoInteira ingresso = Fabrica.criaIngressoInteira(cliente, filmeEscolhido, numeroDaSessao);
				listaDeIngressos.adiciona(ingresso);
			}
		}
	}	
	
	private void estilo() {
		System.out.println("");
		System.out.println("---------------------------------------------");
		System.out.println("");
	}

	private int getInt(String str) {
		Reader r = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer st = new StreamTokenizer(r);
		if (str != "") System.out.println(str);
		try {
			st.nextToken();
		} catch (IOException e) {
			System.out.println("Erro na leitura do teclado");
			return (0);
		}
		return ((int) st.nval);
	}
	
	private static String getString() {
		String s; 
		Scanner sc = new Scanner(System.in); 
 		s = sc.nextLine(); 
		return s;
	}

}