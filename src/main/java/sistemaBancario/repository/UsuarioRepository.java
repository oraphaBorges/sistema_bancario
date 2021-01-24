package sistemaBancario.repository;

import javax.persistence.EntityManager;

import sistemaBancario.models.Usuario;
import sistemaBancario.utils.ConexaoFactory;

public class UsuarioRepository {

	private EntityManager em;
	
	public UsuarioRepository() {
		this.em = ConexaoFactory.getConexao();
	}
	
	public Usuario findById(Integer id) {
			return em.find(Usuario.class,id);
	}
	public void create(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
