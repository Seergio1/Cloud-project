package com.example.stock.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Models.Article_magasin;
import com.example.stock.Repository.ArticleRepository;
import com.example.stock.Repository.Article_magasinRepository;
import jakarta.transaction.Transactional;

@Service
public class Article_magasinService {
    
    @Autowired
    Article_magasinRepository article_magasinRepository;

    public List<Article_magasin> getAllArticle(){
		return article_magasinRepository.findAll();
	}

    public void addNewArticle(Article_magasin infoMagasin) {
		article_magasinRepository.save(infoMagasin);
    }

    public Optional<Article_magasin> getArticleById(Long id){
		return article_magasinRepository.findById(id);
	}

    public void deleteArticle(Long articleId){
		boolean exists = article_magasinRepository.existsById(articleId);
		if(!exists){
			throw new IllegalStateException("Article with id" + articleId+ "does not exists");
		}
		article_magasinRepository.deleteById(articleId);
	}
}
