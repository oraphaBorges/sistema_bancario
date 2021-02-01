package sistemaBancario.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_plano_contas")
public class PlanoConta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String finalidade;

	@ManyToOne
	@JoinColumn(name = "usuario_login", referencedColumnName = "login", nullable = false, foreignKey = @ForeignKey(name = "pk_conta_login"))
	private Usuario usuario;

	@Embedded
	private Registro data = new Registro();

	public PlanoConta(Usuario usuario, String finalidade) {
		this.usuario = usuario;
		this.finalidade = finalidade;
	}

	public PlanoConta() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
