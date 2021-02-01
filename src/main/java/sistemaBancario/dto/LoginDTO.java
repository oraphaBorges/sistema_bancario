package sistemaBancario.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {
	@NotBlank(message = "Obrigatório informar usuário")
	@Size(max = 50)
	public String usuario;

	@NotBlank(message = "Obrigatório informar senha")
	@Size(max = 50)
	public String senha;
}
