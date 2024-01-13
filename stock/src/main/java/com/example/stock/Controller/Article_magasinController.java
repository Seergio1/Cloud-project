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
import com.example.stock.Models.Article_magasin;
import com.example.stock.Service.Article_magasinService;

@RestController
@RequestMapping(path = "article_magasin")
public class Article_magasinController {
    @Autowired
    Article_magasinService article_magasinService;

    @GetMapping(path = "/listeArticle")
	public List<Article_magasin> getAllEmployer(){
		return article_magasinService.getAllArticle();
	}

    @PostMapping(path = "/addNewArticle")
    public void saveArticle(@RequestBody Article_magasin article){
		article_magasinService.addNewArticle(article);
	}

    @GetMapping(path = "/articleById/{id}")
    public ResponseEntity<Article_magasin> getEmployerById(@PathVariable Long id){
        Optional<Article_magasin> article = article_magasinService.getArticleById(id);

        if (article.isPresent()) {
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/deleteArticle/{articleId}")
    public void deleteEmployer(@PathVariable("articleId") Long articleId){
        article_magasinService.deleteArticle(articleId);
    }

    // @PutMapping(path = "/updateArticle/{articleId}")
    // public void updateArticle(@RequestBody Article article){
    //     article_magasinService.updateArticle(article);
    // }

}
