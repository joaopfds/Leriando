package com.estdois.leriando.controller;

import com.estdois.leriando.entity.Post;
import com.estdois.leriando.entity.Usuario;
import com.estdois.leriando.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping("")
    public String ListarPosts(Model model){
        model.addAttribute("posts",postRepository.findAll());
        return "ListaDePosts";
    }

    @GetMapping("/add")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping("/process")
    public String processFrom(@Validated Post post, BindingResult result){
        if (result.hasErrors()){
            return "postForm";
        }
        postRepository.save(post);
        return "redirect:/";
    }


}
