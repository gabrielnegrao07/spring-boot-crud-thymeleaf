package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.controller;

import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Papel;
import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Usuario;
import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/user/create")
    public ModelAndView cadUser() {
        ModelAndView mv = new ModelAndView("/criar-usuario.html");
        List<Papel> listaPapel = service.buscarPapeis();
        mv.addObject("listaPapel", listaPapel);
        return mv;
    }

    @PostMapping("/user/create")
    public ModelAndView cadastrar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirAttr) {
        ModelAndView mv = new ModelAndView("redirect:/user/all");
        service.cadastrar(usuario);
        return mv;
    }

    @GetMapping("/user/all")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/listagem-usuarios.html");
        List<Usuario> listaUsuarios = service.buscar();
        mv.addObject("listaUsuarios", listaUsuarios);
        return mv;
    }

    @GetMapping("/user/update/{idUsuario}")
    public ModelAndView buscarPorId(@PathVariable("idUsuario") Long idUsuario) {
        ModelAndView mv = new ModelAndView("/editar-usuario.html");
        Usuario usuario = service.buscarPorId(idUsuario);
        List<Papel> listaPapel = service.buscarPapeis();
        mv.addObject("listaPapel", listaPapel);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @PostMapping("/user/update/{idUsuario}")
    public ModelAndView atualizar(@PathVariable("idUsuario") Long idUsuario, @ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirAttr) {
        ModelAndView mv = new ModelAndView("redirect:/user/all");
        Usuario usuarioAtualizado = service.atualizar(usuario, idUsuario);
        mv.addObject("usuarioAtualizado", usuarioAtualizado);
        return mv;
    }

    @DeleteMapping("/user/delete/{idUsuario}")
    public void deletar(@PathVariable("idUsuario") Long idUsuario) {
        service.remover(idUsuario);
    }

}
