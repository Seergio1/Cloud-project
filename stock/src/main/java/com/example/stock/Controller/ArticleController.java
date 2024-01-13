package com.example.stock.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Models.Article;
import com.example.stock.Service.ArticleService;

@RestController
@RequestMapping(path = "article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping(path = "/listeArticle")
    public List<Article> getAllEmployer() {
        return articleService.getAllArticle();
    }

    @PostMapping(path = "/addNewArticle")
    public void saveArticle(@RequestBody Article article) {
        articleService.addNewArticle(article);
    }

    @GetMapping(path = "/articleById/{id}")
    public ResponseEntity<Article> getEmployerById(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticleById(id);

        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/deleteArticle/{articleId}")
    public void deleteEmployer(@PathVariable("articleId") Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @PutMapping(path = "/updateArticle/{articleId}")
    public void updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
    }

}
