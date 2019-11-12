package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.repository;

import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {
}
