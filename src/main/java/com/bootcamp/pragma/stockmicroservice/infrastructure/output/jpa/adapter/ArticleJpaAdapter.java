package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter;

import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.ArticleEntity;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.ArticleEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.ArticleRepository;
import com.bootcamp.pragma.stockmicroservice.infrastructure.util.ArticleConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistencePort {

    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

    @Override
    public void save(Article article) {
        articleRepository.save(articleEntityMapper.modelToArticleEntity(article));
    }

    @Override
    public ContentPage<Article> findAllArticles(int page, int size, boolean isAsc, String sortBy) {
        Sort sort = isAsc ? Sort.by(ArticleConstants.getValueSortMappingArticle(sortBy)).ascending() : Sort.by(ArticleConstants.getValueSortMappingArticle(sortBy)).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ArticleEntity> articlesPage = articleRepository.findAll(pageable);
        List<Article> articles = articleEntityMapper.entityToArticleModelList(articlesPage.getContent());
        return new ContentPage<>(
                articlesPage.getTotalPages(),
                articlesPage.getTotalElements(),
                articlesPage.getPageable().getPageNumber(),
                articlesPage.getPageable().getPageSize(),
                articlesPage.isFirst(),
                articlesPage.isLast(),
                articles
        );
    }
}
