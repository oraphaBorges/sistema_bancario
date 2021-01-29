package sistemaBancario.repository;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long >{

	
	public Usuario findByLogin(String login);
	
	/*
	 * VERIFICAR A REGRA DE NEGOCIO
	 * 
	 * public boolean exists(String login) {		
		Query query = em.createQuery("select u from Usuario u where u.login = :login"); //JPQL
		query.setParameter("login", login);
		return query.getResultList().size()!=0;
	}
	
	 * 
	 * 
	 */
	

	
}
