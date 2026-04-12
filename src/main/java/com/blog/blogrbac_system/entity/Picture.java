package com.blog.blogrbac_system.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Data
@Table(name = "picture", schema = "articles")
public class Picture {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_id_gen")
    @SequenceGenerator(name = "picture_id_gen", sequenceName = "picture_pkid_picture_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_picture")
    private Integer id;

    @Column(name = "public_id", nullable = false)
    private String cloudinaryId;

    @Column(name = "picture_url")
    private  String url;

    @Column(name = "origin_name")
    private String originalName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "upload_date")
    private Instant uploadAt;

    @OneToOne(mappedBy = "fkidPicture")
    private Article article;
}
