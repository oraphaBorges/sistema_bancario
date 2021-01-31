package sistemaBancario.dto;

import java.time.LocalDate;

public class LancamentoDTO {
	
	private LocalDate date; 
	private Long contaOrigem;
	private String loginOrigem;
	private Long contaDestino;
	private String loginDestino;
	private Long planoConta;
	private String planoContaFinalidade;
	private double valor;
	private String descricao;
			

	public LancamentoDTO(Long origem, double valor, Long destino,Long planoConta, String descricao) {
		this.date = LocalDate.now();
		this.contaOrigem = origem; 
		this.contaDestino = destino;
		this.valor = valor;
		this.descricao = descricao;
		this.setPlanoConta(planoConta);
	}

	public LancamentoDTO(){}


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
		return getPlanoConta();
	}

	public void setPlanoDeConta(Long planoConta) {
		this.setPlanoConta(planoConta);
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

	public Long getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Long planoConta) {
		this.planoConta = planoConta;
	}

	public void setLoginOrigem(String loginOrigem) {
		this.loginOrigem = loginOrigem;
	}

	public void setLoginDestino(String loginDestino) {
		this.loginDestino = loginDestino;
	}

	public void setPlanoContaFinalidade(String planoContaFinalidade) {
		this.planoContaFinalidade = planoContaFinalidade;
	}
}
