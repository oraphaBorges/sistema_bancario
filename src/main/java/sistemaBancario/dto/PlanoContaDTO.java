package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

public class PlanoContaDTO {
	
	@ApiModelProperty(example = "DEPOSITO")
	public String finalidade;

	@ApiModelProperty(example = "jisoo")
	public String login;
}
