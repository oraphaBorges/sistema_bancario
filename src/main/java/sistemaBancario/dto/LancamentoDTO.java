package sistemaBancario.dto;

import java.time.LocalDate;

public class LancamentoDTO {
	
	private LocalDate date; 
	private ContaSimplesDTO contaOrigem;
	private ContaSimplesDTO contaDestino;
	private String planoConta;
	private double valor;
	private String descricao;
			

	public LancamentoDTO(ContaSimplesDTO origem, double valor, ContaSimplesDTO destino,String planoConta, String descricao) {
		this.date = LocalDate.now();
		this.setContaOrigem(origem); 
		this.setContaDestino(destino);
		this.valor = valor;
		this.descricao = descricao;
		this.planoConta = planoConta;
	}

	public LancamentoDTO (){}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public String getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(String planoConta) {
		this.planoConta = planoConta;
	}

	public ContaSimplesDTO getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(ContaSimplesDTO contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public ContaSimplesDTO getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaSimplesDTO contaDestino) {
		this.contaDestino = contaDestino;
	}


}
