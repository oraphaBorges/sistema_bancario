package sistemaBancario.dto;

import java.time.LocalDate;

public class LancamentoDTO {
	
	private LocalDate date; 
	private int contaOrigem; 
	private int contaDestino; 
	private int planoDeConta;
	private double valor;
	private String descricao;
			
	public LancamentoDTO(LocalDate date, int contaOrigem, int contaDestino, int planoDeConta, double valor,
			String descricao) {
		super();
		this.date = date;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.planoDeConta = planoDeConta;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public int getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}
	public int getPlanoDeConta() {
		return planoDeConta;
	}
	public void setPlanoDeConta(int planoDeConta) {
		this.planoDeConta = planoDeConta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
		
}
