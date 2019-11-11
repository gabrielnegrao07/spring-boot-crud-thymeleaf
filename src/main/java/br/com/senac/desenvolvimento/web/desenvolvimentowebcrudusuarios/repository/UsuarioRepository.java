package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.repository;

import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
