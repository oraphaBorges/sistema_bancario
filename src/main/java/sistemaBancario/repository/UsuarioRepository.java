package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaBancario.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long > {

	Usuario findByLogin(String login);
}