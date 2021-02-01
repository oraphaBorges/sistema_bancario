package sistemaBancario.dto;

import java.util.ArrayList;

import sistemaBancario.enums.Sigla;

public class DashboardDTO {
	public Sigla tipo;
	public Double saldo;
	public Long id;
	public ArrayList<LancamentoDTO> lancamentos;
}
