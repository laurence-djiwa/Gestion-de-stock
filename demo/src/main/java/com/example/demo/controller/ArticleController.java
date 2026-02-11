package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/stock")
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service){
        this.service = service;
    }
/*
    @GetMapping
    public ModelAndView listArticles(){
        ModelAndView mv = new ModelAndView("liste");
        mv.addObject("articles", service.listeArticles());
        return mv;
    }*/

    @GetMapping("/")
    public String listArticles(Model model) {
        model.addAttribute("articles", service.listeArticles());
        return "liste";   // PAS store/liste
    }

    @GetMapping("/creation")
    public ModelAndView formulaireCreation() {
        return new ModelAndView("creation");
    }

    @PostMapping("/creation")
    public RedirectView creationArticle(@RequestParam String designation,
                                        @RequestParam String description,
                                        @RequestParam double prix,
                                        @RequestParam int quantite) {
        service.ajouterArticle(designation, description, prix, quantite);
        return new RedirectView("/stock/");
    }

    @PostMapping("/{id}/supprimer")
    public RedirectView supprimer(@PathVariable Integer id) {
        service.supprimerArticle(id);
        return new RedirectView("/stock/");
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Test OK";
    }

}
