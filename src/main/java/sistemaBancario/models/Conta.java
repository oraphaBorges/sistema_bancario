package sistemaBancario.models;

import javax.persistence.*;

import sistemaBancario.enums.Sigla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Sigla sigla;
		
	@Column(nullable = false)
	private Double saldo=0.0;

	@OneToOne
	@JoinColumn(name = "usuario_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "pk_login"))
	private Usuario titular;
	
	@Embedded
    private Registro data = new Registro();
	
	public Conta() {}
	public Conta(String nome, Sigla sigla,Usuario titular ) {
		this.nome = nome;
		this.sigla = sigla;
		this.titular = titular;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sigla getSigla() {
		return sigla;
	}
	public void setSigla(Sigla sigla) {
		this.sigla = sigla;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Long getId() {
		return id;
	}
	
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario usuario) {
		this.titular = usuario;
	}
	public Registro getData() {
		return data;
	}
	public void setData(Registro data) {
		this.data = data;
	}
}
