package com.example.springBootProject.web;

import com.example.springBootProject.config.auth.LoginUser;
import com.example.springBootProject.config.auth.dto.SessionUser;
import com.example.springBootProject.service.posts.PostsService;
import com.example.springBootProject.web.dto.PostsResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findALlDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("username", user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
