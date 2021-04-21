package com.estdois.leriando.controller;

import com.estdois.leriando.entity.Post;
import com.estdois.leriando.entity.Usuario;
import com.estdois.leriando.persistence.ComentarioRepository;
import com.estdois.leriando.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    static List<String> listaDeTipos = null;

    static {
        listaDeTipos = new ArrayList<>();
        listaDeTipos.add("matemática");
        listaDeTipos.add("portugues");
        listaDeTipos.add("ingles");
        listaDeTipos.add("espanhol");
        listaDeTipos.add("história");
        listaDeTipos.add("ciências");
        listaDeTipos.add("geografia");
        listaDeTipos.add("redação");
    }

    @Autowired
    PostRepository postRepository;

    @Autowired
    ComentarioRepository comentRepository;

    @RequestMapping("/post")
    public String ListarPosts(Model model){
        model.addAttribute("posts",postRepository.findAll());
        model.addAttribute("coments", comentRepository.findAll());
        //List<Post> postcoment = null;
        //postcoment = new ArrayList<>();
        //postcoment.add(postRepository.findAll());
        //model.addAttribute("coments", )
        return "ListaDePosts";
    }

    @GetMapping("/post/add")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("listaDeTipos", listaDeTipos);
        return "postForm";
    }

    @PostMapping("/post/process")
    public String processFrom(@Validated Post post, BindingResult result){
        if (result.hasErrors()){
            return "postForm";
        }

        if (post.getText() != ""){
            postRepository.save(post);
            return "redirect:/post";
        }else{
            return "postForm";
        }
    }


}
