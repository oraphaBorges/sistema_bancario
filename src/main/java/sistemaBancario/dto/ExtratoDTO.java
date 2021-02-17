package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

public class ExtratoDTO {

	@ApiModelProperty(example = "50.30")
	public Double saldo;
	public ArrayList<LancamentoDTO> lancamentos;
	
	public ExtratoDTO(Double saldo, ArrayList<LancamentoDTO> lancamentos) {
		this.saldo = saldo;
		this.lancamentos = lancamentos;
	}
}
