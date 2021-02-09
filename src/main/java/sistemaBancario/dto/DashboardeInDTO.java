package sistemaBancario.dto;

import io.swagger.annotations.ApiModelProperty;

public class DashboardeInDTO {
	@ApiModelProperty(example = "jisoo")
	public String login;
	@ApiModelProperty(example = "2021-09-02")
	public String inicio;
	@ApiModelProperty(example = "2020-09-02")
	public String fim;
	
}
