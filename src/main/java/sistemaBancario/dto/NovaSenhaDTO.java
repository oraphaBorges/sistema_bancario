package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

public class NovaSenhaDTO {
	@ApiModelProperty(example = "jisoo.pretorosa@yg.kr")
	public String email;
	@ApiModelProperty(example = "jisoo")
	public String login;
}
