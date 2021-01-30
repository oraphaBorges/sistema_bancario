package sistemaBancario.dto;

import java.time.LocalDate;

public class LancamentoDTO {
	
	private LocalDate date; 
	private long contaOrigem; 
	private long contaDestino; 
	private long planoConta;
	private double valor;
	private String descricao;
			
	public LancamentoDTO(long contaOrigem,double valor, long contaDestino, long planoConta, String descricao) {
		super();
		this.date = LocalDate.now();
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.planoConta = planoConta;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public long getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public long getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(long contaDestino) {
		this.contaDestino = contaDestino;
	}
	public long getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(long planoConta) {
		this.planoConta = planoConta;
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
