package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

public class PlanoContaDTO {
	public Long id;
	@ApiModelProperty(example = "DEPOSITO")
	public String finalidade;

	@ApiModelProperty(example = "DTO.red")
	public String login;
}
