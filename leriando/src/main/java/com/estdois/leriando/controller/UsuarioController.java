package com.estdois.leriando.controller;

import com.estdois.leriando.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estdois.leriando.persistence.UsuarioRespository;
@Controller
public class UsuarioController {

    @Autowired
    UsuarioRespository usuarioRepository;

    @RequestMapping("/")
    public String listarUsuarios(Model model){
        model.addAttribute( "usuarios", usuarioRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarioForm";
    }

    @PostMapping("/process")
    public String processFrom(@Validated Usuario usuario, BindingResult result){
        if (result.hasErrors()){
            return "usuarioForm";
        }
        usuarioRepository.save(usuario);
        return "redirect:/";
    }
}

