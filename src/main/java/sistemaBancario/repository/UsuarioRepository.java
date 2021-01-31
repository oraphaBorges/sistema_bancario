package sistemaBancario.repository;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long > {

	Usuario findByLogin(String login);

	boolean existsByLogin(String login);
}