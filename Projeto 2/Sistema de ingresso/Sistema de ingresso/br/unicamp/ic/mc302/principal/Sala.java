package br.unicamp.ic.mc302.principal;

public class Sala {
	
	private int numeroDelugares;
	private int numeroDelugaresFaltantes;
	
	public Sala(int numeroDeLugares) {
		this.numeroDelugares = numeroDeLugares;
		this.numeroDelugaresFaltantes = numeroDelugares;
	}
	
	public int getNumeroDeLugaresFaltantes() {
		return numeroDelugaresFaltantes;
	}
	
	public void ocupaLugar(int quantidadeDeLugaresOcupados) {
		if ( quantidadeDeLugaresOcupados > numeroDelugaresFaltantes ) {
			System.out.println("Nao eh possivel comprar " + quantidadeDeLugaresOcupados + 
							   " lugares. A quantidade disponivel eh " + numeroDelugaresFaltantes);
		} else {
			numeroDelugaresFaltantes -= quantidadeDeLugaresOcupados;
		}
	}
	
	public void desocupaLugar(int numero) {
		numeroDelugaresFaltantes += numero;
	}

}
