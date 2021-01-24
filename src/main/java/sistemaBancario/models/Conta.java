package sistemaBancario.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String nome;
	
	public Sigla sigla;
	
	public Double saldo;
	
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
	public Integer getId() {
		return id;
	}
	
}
