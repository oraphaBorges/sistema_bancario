package sistemaBancario.repository;

import javax.persistence.Query;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Usuario;

public class UsuarioRepository extends RepositoryGeneric<Usuario>{

	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public boolean exists(String login) {
		Query query = em.createQuery("select u from Usuario u where u.login = :login"); //JPQL
		query.setParameter("login", login);
		return query.getResultList().size()!=0;
	}
	

	
}
