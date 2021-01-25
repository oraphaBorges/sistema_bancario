package sistemaBancario.generics;

import javax.persistence.EntityManager;

import sistemaBancario.models.Conta;
import sistemaBancario.utils.ConexaoFactory;

public class RepositoryGeneric <T> {
	protected EntityManager em;
	private Class entidadeGenerica;

	public RepositoryGeneric() {
		this.em = ConexaoFactory.getConexao();
	}

	public void create(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(T t) {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(T t) {
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
