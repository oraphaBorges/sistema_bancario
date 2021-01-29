package sistemaBancario.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, length = 20)
	private String login;

	@Column(nullable = false)
	private String senha;

	@Column(length = 11, nullable = false)
	private String cpf;

	@OneToMany(mappedBy = "titular", cascade = CascadeType.PERSIST)
	private List<Conta> contas = new ArrayList<Conta>();
	
	@Embedded
    private Registro data = new Registro();
	
	public Usuario() {}
	public Usuario(String nome, String login,String senha, String cpf) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void addConta(Conta conta) {
		//conta.setProprietario(this);
		this.contas.add(conta);
	}
	public Registro getData() {
		return data;
	}
	public void setData(Registro data) {
		this.data = data;
	}

	

}
