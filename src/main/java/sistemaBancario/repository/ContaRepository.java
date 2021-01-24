package sistemaBancario.repository;

import javax.persistence.EntityManager;

import sistemaBancario.models.Conta;
import sistemaBancario.utils.ConexaoFactory;

public class ContaRepository {
	private EntityManager em;

	public ContaRepository() {
		this.em = ConexaoFactory.getConexao();
	}

	public Conta findById(Integer id) {
		return em.find(Conta.class, id);
	}

	public void create(Conta conta) {
		try {
			em.getTransaction().begin();
			em.persist(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Conta conta) {
		try {
			em.getTransaction().begin();
			em.merge(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Conta conta) {
		try {
			em.getTransaction().begin();
			em.remove(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
