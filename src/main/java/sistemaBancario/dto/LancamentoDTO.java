package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class LancamentoDTO {

	@ApiModelProperty(example = "2020-12-12")
	private String date;

	@ApiModelProperty(example = "DTO.black")
	@NotBlank(message = "Obrigatório informar conta de origem")
	@Size(max = 50)
	private ContaSimplesDTO contaOrigem;

	@ApiModelProperty(example = "DTO.white")
	private ContaSimplesDTO contaDestino;

	@ApiModelProperty(example = "DEPOSITO")
	@NotBlank(message = "Obrigatório informar plano de conta")
	@Size(max = 30)
	private String planoConta;

	@ApiModelProperty(example = "50.30")
	@NotBlank(message = "Obrigatório informar o valor do lançamento")
	@Size(max = 30)
	private double valor;

	@ApiModelProperty(example = "Compra de brinquedos")
	private String descricao;
			

	public LancamentoDTO(ContaSimplesDTO origem, double valor, ContaSimplesDTO destino,String planoConta, String descricao) {
		this.setDate(LocalDate.now().toString());
		this.setContaOrigem(origem); 
		this.setContaDestino(destino);
		this.valor = valor;
		this.descricao = descricao;
		this.planoConta = planoConta;
	}

	public LancamentoDTO (){}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
