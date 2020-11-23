package br.unicamp.ic.mc302.principal;

public class Sessao {
	
	private String horario;
	private Sala sala;
	private EstadoDeSessao estado;
	private EstadoLotado estadoLotado;
	private EstadoNormal estadoNormal;
	
	public Sessao(String horario) {
		this.horario = horario;
		this.sala = new Sala(3);
		estadoNormal = new EstadoNormal();
		estadoLotado = new EstadoLotado();
		estado = estadoNormal;
	}
	
	public int getNumeroDeLugaresFaltantes() {
		if (sala.getNumeroDeLugaresFaltantes() == 0) {
			mudaEstado();
			estado.estadoDaSessao();
		}
		return sala.getNumeroDeLugaresFaltantes();
	}
	
	public void ocupaLugar(int quantidadeDeLugaresOcupados) {
		sala.ocupaLugar(quantidadeDeLugaresOcupados);
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void desocupaLugar(int numero) {
		sala.desocupaLugar(numero);
		estado = estadoNormal;
	}
	
	public void mudaEstado() {
		if (estado instanceof EstadoLotado) {
			estado = estadoNormal;
		} else {
			estado = estadoLotado;
		}
		
	}
}
