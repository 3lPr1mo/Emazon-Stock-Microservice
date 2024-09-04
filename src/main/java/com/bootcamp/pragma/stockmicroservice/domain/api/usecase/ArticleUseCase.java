package com.bootcamp.pragma.stockmicroservice.domain.api.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.IArticleServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.ICategoryServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.exception.*;
import com.bootcamp.pragma.stockmicroservice.domain.model.Article;
import com.bootcamp.pragma.stockmicroservice.domain.model.Category;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IArticlePersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.util.ArticleConstants;
import com.bootcamp.pragma.stockmicroservice.domain.util.Constants;

import java.util.List;
import java.util.Set;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;
    private final ICategoryServicePort categoryServicePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort, ICategoryServicePort categoryServicePort) {
        this.articlePersistencePort = articlePersistencePort;
        this.categoryServicePort = categoryServicePort;
    }

    @Override
    public void saveArticle(Article article) {
        if(article.getCategories().size() < ArticleConstants.MIN_CATEGORIES){
            throw new InsufficientCategoriesException(ArticleConstants.MIN_CATEGORIES_MESSAGE);
        }
        if (article.getCategories().size() > ArticleConstants.MAX_CATEGORIES){
            throw new ExcessiveCategoriesException(ArticleConstants.MAX_CATEGORIES_MESSAGE);
        }
        if(!categoriesAreUnique(article.getCategories())){
            throw new DuplicateCategoriesException(ArticleConstants.DUPLICATE_CATEGORIES_MESSAGE);
        }

        checkIfCategoryExist(article.getCategories());

        articlePersistencePort.save(article);
    }

    @Override
    public ContentPage<Article> findAllArticles(int page, int size, boolean isAsc, String sortBy) {
        ContentPage<Article> contentPage = articlePersistencePort.findAllArticles(page, size, isAsc, sortBy);
        if (contentPage.getContent().isEmpty()) {
            throw new NoDataFoundException(Constants.NO_DATA_FOUND_ARTICLE_EXCEPTION_MESSAGE);
        }
        if(!isValidSortBy(sortBy)) {
            throw new ArticlePageSortByIsInvalidException(ArticleConstants.INVALID_SORTBY_MESSAGE);
        }
        return contentPage;
    }

    private boolean categoriesAreUnique(List<Category> categories) {
        Set<Long> uniqueCategoriesId = Set.copyOf(categories.stream().map(Category::getId).toList());
        return uniqueCategoriesId.size() == categories.size();
    }

    private void checkIfCategoryExist(List<Category> categories) {
        for(Category  category : categories){
            categoryServicePort.findCategoryById(category.getId());
        }
    }

    private boolean isValidSortBy(String sortBy) {
        for (ArticleConstants.SortBy value : ArticleConstants.SortBy.values()) {
            System.out.println(sortBy);
            System.out.println(value.name().equalsIgnoreCase(sortBy));
            if(!(value.name().equalsIgnoreCase(sortBy))){
                return false;
            }
        }
        return true;
    }
}
