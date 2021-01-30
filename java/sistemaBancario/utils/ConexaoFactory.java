package sistemaBancario.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFactory {
	private static EntityManager em;

	public static EntityManager getConexao() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema_bancario");
			em = emf.createEntityManager();
		}
		return em;
	}
}