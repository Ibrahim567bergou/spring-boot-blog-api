package com.blog.blogrbac_system.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category", schema = "articles")
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_gen")
    @SequenceGenerator(name = "category_id_gen", sequenceName = "category_pkid_category_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_category")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "created_date")
    private Instant createdAt;

    @OneToMany(mappedBy = "fkidCategory")
    private Set<Article> articles = new LinkedHashSet<>();

}
