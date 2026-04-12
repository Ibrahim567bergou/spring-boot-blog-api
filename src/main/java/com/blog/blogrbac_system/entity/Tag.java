package com.blog.blogrbac_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;


@Builder
@Entity
@Table(name = "tags", schema = "articles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_gen")
    @SequenceGenerator(name = "tags_id_gen", sequenceName = "tags_pkid_tag_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_tag")
    private Integer id;

    @Column(name = "name", length = 40, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "created_date")
    private Instant createdAt;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "fkidTag")
    private Set<ArticleTag> articleTags = new LinkedHashSet<>();
}
