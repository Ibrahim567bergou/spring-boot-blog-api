package com.blog.blogrbac_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;


@Entity
@Table(
        name = "articles_tags",
        schema = "articles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"fkid_article", "fkid_tag"})
)
@Setter
@Getter
public class ArticleTag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_tags_id_gen")
    @SequenceGenerator(name = "articles_tags_id_gen", sequenceName = "articles_tags_pkid_article_tag_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_article_tag")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkid_article", nullable = false)
    private Article fkidArticle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_tag", nullable = false)
    private Tag fkidTag;

    @Column(name = "created_date")
    private Instant createdAt;

}
