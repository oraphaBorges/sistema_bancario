package sistemaBancario.dto;

import java.util.ArrayList;

public class ExtratoDTO {
	public Double saldo;
	public ArrayList<LancamentoDTO> lancamentos;
	
	public ExtratoDTO(Double saldo, ArrayList<LancamentoDTO> lancamentos) {
		this.saldo = saldo;
		this.lancamentos = lancamentos;
	}
}
