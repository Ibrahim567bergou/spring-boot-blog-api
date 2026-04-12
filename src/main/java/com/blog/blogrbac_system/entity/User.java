package com.blog.blogrbac_system.entity;

import com.blog.blogrbac_system.constant.Role;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "users", schema = "articles")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_pkid__user_seq", allocationSize = 1, schema = "articles")
    @Column(name = "pkid_user", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "created_date")
    private Instant createdAt;

    @Column(name = "update_date")
    private Instant UpdateAt;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "fkidUser")
    private Set<Article> articles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkidUser")
    @OrderBy("createAt DESC")
    List<Notification> notifications = new ArrayList<>();

}
