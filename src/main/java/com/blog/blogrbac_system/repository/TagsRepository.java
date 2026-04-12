package com.blog.blogrbac_system.repository;

import com.blog.blogrbac_system.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Integer> {

    Optional<Tag> findByName(String name);
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Integer id);
}
