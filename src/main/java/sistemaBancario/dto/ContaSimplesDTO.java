package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;
import sistemaBancario.enums.Sigla;

public class ContaSimplesDTO {
	@ApiModelProperty(example = "jisoo")
	public String login;
	@ApiModelProperty(example = "POUPANCA")
	public Sigla sigla;

	public ContaSimplesDTO(String login, Sigla sigla) {
		this.login = login;
		this.sigla = sigla;
	}

}
