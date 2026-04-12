package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.constant.StatusArticle;
import com.blog.blogrbac_system.dto.request.ArticleCreateRequest;
import com.blog.blogrbac_system.dto.request.ArticleUpdateRequest;
import com.blog.blogrbac_system.dto.response.ArticleResponse;
import com.blog.blogrbac_system.entity.*;
import com.blog.blogrbac_system.event.notificationEvent.ArticleCreatedEvent;
import com.blog.blogrbac_system.event.notificationEvent.ArticleUpdateEvent;
import com.blog.blogrbac_system.event.PictureDeleteEvent;
import com.blog.blogrbac_system.exception.exceptions.ArticleNotFoundException;
import com.blog.blogrbac_system.exception.exceptions.GeneralException;
import com.blog.blogrbac_system.exception.exceptions.UserNotFoundException;
import com.blog.blogrbac_system.mapper.ArticleMapper;
import com.blog.blogrbac_system.repository.*;
import com.blog.blogrbac_system.service.ArticleService;
import com.blog.blogrbac_system.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;


@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final TagsRepository tagsRepository;
    private final ArticleTagRepository articleTagRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PictureService pictureService;
    private final ArticleMapper articleMapper;
    private final ApplicationEventPublisher publisher;



    @Override
    public ArticleResponse createArticle(ArticleCreateRequest request) {
        Article article = new Article();
        article.setCreatedAt(Instant.now());
        article.setViewed(0);
        article.setLikedCount(0);
        article.setFkidUser(this.getUser(1));
        mapToArticle(request, article);
        article = articleRepository.save(article);
        handleTagsCreate(request, article);
        publisher.publishEvent(new ArticleCreatedEvent(article.getFkidUser().getId(), article.getTitle()));
        return articleMapper.apply(article);
    }

    @Override
    public ArticleResponse updateArticle(ArticleUpdateRequest request) {
        Integer id = request.getId();
        Article article = this.get(id);
        article.setUpdateAt(Instant.now());
        mapToArticle(request, article);
        article = articleRepository.save(article);
        handleTagsUpdate(request, article);
        publisher.publishEvent(new ArticleUpdateEvent(article.getFkidUser().getId(), article.getTitle()));
        return articleMapper.apply(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        if(id == null){
            return ;
        }
        Article article = this.get(id);
        Integer pictureId = article.getFkidPicture().getId();
        publisher.publishEvent(new PictureDeleteEvent(pictureId));
        articleRepository.delete(article);
    }

    @Override
    public ArticleResponse getById(Integer id) {
        return articleMapper.apply(this.get(id));
    }

    @Override
    public List<ArticleResponse> getAllArticle() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper)
                .toList();
    }

    @Override
    public ArticleResponse searchArticle(String keyword) {
        return null;
    }

    private Article get(Integer id){
        return articleRepository.findById(id).orElseThrow(
                () -> new ArticleNotFoundException(id)
        );
    }
    private Category getCategory(String name){
        return categoryRepository.findByName(name).orElseThrow(
                () -> new GeneralException("Category " + name + " not found")
        );
    }
    private Set<ArticleTag> getTags(List<String> tags, Article article){
        if(tags == null || tags.isEmpty()){
            return Collections.emptySet();
        }
        List<ArticleTag> articleTags = tags.stream()
                .map(tagName ->{
                    Tag tag = tagsRepository.findByName(tagName).orElseThrow(
                            () -> new GeneralException("Tag not found " + tagName)
                    );
                    ArticleTag articleTag = new ArticleTag();
                    articleTag.setFkidTag(tag);
                    articleTag.setFkidArticle(article);
                    articleTag.setCreatedAt(Instant.now());
                    return articleTag;
                })
                .toList();
        return new LinkedHashSet<>(articleTagRepository.saveAll(articleTags));
    }

    private User getUser(Integer id){
        return userRepository.findById(1).orElseThrow(
                () -> new UserNotFoundException(1)
        );
    }
    private void mapToArticle(ArticleCreateRequest request, Article article){
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setStatusArticle(StatusArticle.valueOf(request.getStatusArticle()));
        if(request.getCategory() != null){
            article.setFkidCategory(this.getCategory(request.getCategory()));
        }if(request.getPicture() != null && !request.getPicture().isEmpty()){
            Picture picture = pictureService.uploadPicture(request.getPicture());
            article.setFkidPicture(picture);
        }
    }
    private void mapToArticle(ArticleUpdateRequest request, Article article){
        if(request.getTitle() != null){
            article.setTitle(request.getTitle());
        }if(request.getContent() != null){
            article.setContent(request.getContent());
        }if(request.getCategory() != null){
            article.setFkidCategory(this.getCategory(request.getCategory()));
        }if(request.getStatusArticle() != null){
            article.setStatusArticle(StatusArticle.valueOf(request.getStatusArticle()));
        }if(request.getPicture() != null && !request.getPicture().isEmpty()){
            Picture oldPicture = article.getFkidPicture();
            Picture picture = pictureService.uploadPicture(request.getPicture());
            article.setFkidPicture(picture);
            if(oldPicture != null){
                pictureService.deletePicture(oldPicture.getId());
                pictureRepository.delete(oldPicture);
            }
        }
    }
    private void handleTagsUpdate(ArticleUpdateRequest request, Article article){
        if(request.getTags() != null){
            articleTagRepository.deleteAllByFkidArticle(article);
            if(!request.getTags().isEmpty()){
                Set<ArticleTag> tags = this.getTags(request.getTags(), article);
                articleTagRepository.saveAll(tags);
                article.setArticleTag(tags);
            }
        }
    }

    private void handleTagsCreate(ArticleCreateRequest request, Article article){
        if(request.getTags() !=null && !request.getTags().isEmpty()){
            Set<ArticleTag> articleTags = this.getTags(request.getTags(), article);
            articleTagRepository.saveAll(articleTags);
            article.setArticleTag(articleTags);
        }
    }
}
