package sistemaBancario.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_plano_contas")
public class PlanoConta {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String finalidade;
	@Embedded
    private Registro data = new Registro();
	
	
	
	public PlanoConta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanoConta(String finalidade) {
		this.finalidade = finalidade;
	}
	public Long getId() {
		return id;
	}
	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
	public Registro getData() {
		return data;
	}
	public void setData(Registro data) {
		this.data = data;
	}
}
