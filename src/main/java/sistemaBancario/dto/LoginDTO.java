package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {

	@ApiModelProperty(example = "jisoo")
	@NotBlank(message = "Obrigatório informar usuário")
	@Size(max = 50)
	public String usuario;

	@ApiModelProperty(example = "pretorosa")
	@NotBlank(message = "Obrigatório informar senha")
	@Size(max = 50)
	public String senha;
}
