package sistemaBancario.dto;

import java.time.LocalDate;

import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;

public class LancamentoDTO {
	
	private LocalDate date; 
	private Long contaOrigem; 
	private Long contaDestino; 
	private Long planoDeConta;
	private double valor;
	private String descricao;
			
	public LancamentoDTO(Lancamento lancamento, Conta conta, double valor, String descricao) {
		super();
		this.date = lancamento.getDataLancamento();
		this.contaOrigem = conta.getId();
		this.contaDestino = conta.getId();
		this.planoDeConta = conta.getId();
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public LancamentoDTO(LocalDate date ,Long contaOrigem, Long contaDestino, double valor, String descricao) {
		this.date = date;
		this.contaOrigem = contaOrigem; 
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.descricao = descricao;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Long getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Long contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Long getPlanoDeConta() {
		return planoDeConta;
	}

	public void setPlanoDeConta(Long planoDeConta) {
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
