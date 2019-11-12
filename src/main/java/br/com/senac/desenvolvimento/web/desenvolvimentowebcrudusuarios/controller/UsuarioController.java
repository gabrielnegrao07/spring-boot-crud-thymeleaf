package br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.controller;

import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.model.Usuario;
import br.com.senac.desenvolvimento.web.desenvolvimentowebcrudusuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/user/create")
    public ModelAndView cadUser() {
        ModelAndView mv = new ModelAndView("/criar-usuario.html");
        return mv;
    }

    @PostMapping("/user/create")
    public ModelAndView cadastrar(@ModelAttribute("usuario") Usuario usuario) {
        ModelAndView mv = new ModelAndView("/criar-usuario.html");
        service.cadastrar(usuario);
        return mv;
    }

    @GetMapping("/user/all")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/listagem-usuarios.html");
        List<Usuario> listaUsuarios = mockLista();
        mv.addObject("listaUsuarios", listaUsuarios);
        return mv;
    }

    private List<Usuario> mockLista() {
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(Usuario.builder()
                .id(1L)
                .nomeCompleto("Gabriel Negrão Silva")
                .ativado(true)
                .build(), Usuario.builder()
                .id(2L)
                .nomeCompleto("Davi Marques")
                .ativado(false)
                .build()));
        return list;
    }
}
