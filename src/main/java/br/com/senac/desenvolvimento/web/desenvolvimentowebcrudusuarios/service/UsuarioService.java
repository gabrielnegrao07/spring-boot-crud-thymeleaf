package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.service;

import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Usuario;
import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        Usuario usuarioDb = repository.findById(usuario.getId()).orElse(null);
        usuarioDb.setUsername(usuario.getUsername());
        usuarioDb.setNomeCompleto(usuario.getNomeCompleto());
        usuarioDb.setSenha(usuario.getSenha());
        usuarioDb.setAtivado(usuario.getAtivado());
        usuarioDb.setPapeis(usuario.getPapeis());
        return repository.save(usuarioDb);
    }

    public Boolean remover(Long idUsuario) {
        repository.deleteById(idUsuario);
        return true;
    }

    public List<Usuario> buscar() {
        return repository.findAll();
    }


}
