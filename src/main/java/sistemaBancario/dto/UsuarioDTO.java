package sistemaBancario.dto;

public class UsuarioDTO {
	public String cpf;
	public String login;
	public String nome;
	public String senha;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(String cpf, String login, String nome, String senha) {
		this.cpf = cpf;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
}
