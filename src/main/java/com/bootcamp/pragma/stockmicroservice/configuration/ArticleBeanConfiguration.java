package com.bootcamp.pragma.stockmicroservice.configuration;

import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.ArticleUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter.ArticleJpaAdapter;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.ArticleEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ArticleBeanConfiguration {
    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final CategoryBeanConfiguration categoryBeanConfiguration;

    @Bean
    public IArticlePersistencePort articlePersistencePort() {
        return new ArticleJpaAdapter(articleRepository, articleEntityMapper);
    }

    @Bean
    public IArticleServicePort articleServicePort() {
        return new ArticleUseCase(articlePersistencePort(), categoryBeanConfiguration.categoryServicePort());
    }

}
