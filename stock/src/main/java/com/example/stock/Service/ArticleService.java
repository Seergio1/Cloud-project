package com.example.stock.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Models.Article;
import com.example.stock.Repository.ArticleRepository;

import jakarta.transaction.Transactional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    
    
    public List<Article> getAllArticle(){
		return articleRepository.findAll();
	}

    public void addNewArticle(Article article) {
		
        Optional<Article> articleCode = articleRepository.findArticleByCode(article.getCode());
		if(articleCode.isPresent()){
			throw new IllegalStateException("Code is taken");
		}

        Optional<Article> articleName = articleRepository.findArticleByName(article.getName());
		if(articleName.isPresent()){
			throw new IllegalStateException("Name is taken");
		}

		articleRepository.save(article);
    }

    public Optional<Article> getArticleById(Long id){
		return articleRepository.findById(id);
	}

    public void deleteArticle(Long articleId){
		boolean exists = articleRepository.existsById(articleId);
		if(!exists){
			throw new IllegalStateException("Article with id" + articleId+ "does not exists");
		}
		articleRepository.deleteById(articleId);
	}

    @Transactional
	public void updateArticle(Article articleObject){
		Article article = articleRepository.findById(articleObject.getId())
		.orElseThrow(() -> new IllegalStateException("Article with id" + articleObject.getId()+ "does not exists"));

		if(articleObject.getName() != null && articleObject.getName().length()>0 && !Objects.equals(article.getName(), articleObject.getName())){
            Optional<Article> artOptional = articleRepository.findArticleByName(articleObject.getName());
			if(artOptional.isPresent()){
				throw new IllegalStateException("name taken");
			}
			article.setName(articleObject.getName());
		}
		
		if(articleObject.getCode() != null && articleObject.getCode().length()>0 && !Objects.equals(article.getCode(), articleObject.getCode())){
			Optional<Article> artOptional = articleRepository.findArticleByCode(articleObject.getCode());
			if(artOptional.isPresent()){
				throw new IllegalStateException("code taken");
			}
			article.setCode(articleObject.getCode());
		}

		if(articleObject.getOut_method().getName() != null && !Objects.equals(article.getOut_method().getName(), articleObject.getOut_method().getName())){
			article.setOut_method(articleObject.getOut_method());
		}
		
	}


}
