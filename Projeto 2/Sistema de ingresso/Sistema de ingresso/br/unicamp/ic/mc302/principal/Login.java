package br.unicamp.ic.mc302.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.Gson;

public class Login {
	
	private String nomeDeUsuario;
	private String senha;
	private int entradaInicial;
	Gson gson = new Gson();
	Usuario user = new Usuario();
	Usuario userTest = new Usuario();
	
	public boolean iniciar() throws SenhaInvalidaExc {
		estilo();
		
		System.out.println("Bem vindo ao Ingresso.br!");
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Login");
		System.out.println("2 - Se cadastrar");
		entradaInicial = getInt("");
		
		if (entradaInicial == 1) {
			System.out.println("Digite seu nome de usuario: ");
			nomeDeUsuario = getString();
			System.out.println("Digite sua senha: ");
			senha = getString();
			estilo();

			  try {
				   BufferedReader br = new BufferedReader(
				   new FileReader("Usuarios.json"));
				   Usuario gsonUser = gson.fromJson(br, Usuario.class);
				   try {
					   user.setNome(nomeDeUsuario);
					   user.setSenha(senha);
					   login(gsonUser, user);
				   } catch (SenhaInvalidaExc e) {
					   System.out.println("Senha ou usuario invalido");
					   estilo();
					   iniciar();
				   }

			  } catch (FileNotFoundException e) {
				  e.printStackTrace();
				}
			
			  return true;
			  
		} else if (entradaInicial == 2) {
			// Cadastrar usuario
			System.out.println("Digite o login: ");
			user.setNome(getString());
			System.out.println("Digite a senha: ");
			user.setSenha(getString());			
			
			String json = gson.toJson(user);
			
			  try {
			   //write converted json data to a file named "CountryGSON.json"
			   FileWriter writer = new FileWriter("Usuarios.json");
			   writer.write(json);
			   writer.close();
			  
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			  System.out.println("Cadastro realizado com sucesso!");
			 iniciar();
			
			
			return true;
		} else {
			System.out.println("Digito invalido. Tente novamente (:");
			iniciar();
		}
		return false;
	}
	
	private void login(Usuario usuario, Usuario user) throws SenhaInvalidaExc {
		   if(usuario.getNome().equals(user.getNome()) && usuario.getSenha().equals(user.getSenha())) {
			   System.out.println("Carregando... Login realizado com sucesso!");
		   }
		   else { 
			   throw new SenhaInvalidaExc("Senha invalida");
		   }
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
		} catch (InputMismatchException e) {
			  e.printStackTrace();
			  System.err.println("Entered value is not an integer");
		}
		return ((int) st.nval);
	}
	
	private static String getString() {
		String s; 
		Scanner sc = new Scanner(System.in); 
 		s = sc.nextLine(); 
		return s;
	}
	
	private void estilo() {
		System.out.println("");
		System.out.println("---------------------------------------------");
		System.out.println("");
	}

	
}
