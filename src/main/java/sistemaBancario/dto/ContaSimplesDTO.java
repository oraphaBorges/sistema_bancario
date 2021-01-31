package sistemaBancario.dto;

import sistemaBancario.enums.Sigla;

public class ContaSimplesDTO {
	public String login;
	public Sigla sigla;

	public ContaSimplesDTO(String login, Sigla sigla) {
		this.login = login;
		this.sigla = sigla;
	}

}
