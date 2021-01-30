package sistemaBancario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaBancario.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long >{

	public Optional<Usuario> findById(String usuario);
	
	public Optional<Usuario> findByLogin(String login);
	
	//TODO:IMPLEMENTAR A VERIFICAÇÃO SE O USUARIO EXISTE
}
