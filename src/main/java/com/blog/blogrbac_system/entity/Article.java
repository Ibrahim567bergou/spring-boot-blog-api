package com.blog.blogrbac_system.entity;

import com.blog.blogrbac_system.constant.StatusArticle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "article", schema = "articles")
@Setter
@Getter
public class Article implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_gen")
    @SequenceGenerator(name = "article_id_gen", sequenceName = "article_pkid_article_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_article")
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    private String content;

    @Column(name = "viewed")
    private Integer viewed;

    @Column(name = "like_count")
    private Integer likedCount;

    @Column(name = "create_date")
    private Instant createdAt;

    @Column(name = "update_date")
    private Instant updateAt;

    @Column(name = "status")
    private StatusArticle statusArticle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_user")
    private User fkidUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_category", nullable = false)
    private Category fkidCategory;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fkid_picture")
    private Picture fkidPicture;

    @OneToMany(mappedBy = "fkidArticle", cascade = CascadeType.ALL) //TODO delete cascade and show if tags not save with article
    private Set<ArticleTag> articleTag = new LinkedHashSet<>();

}
