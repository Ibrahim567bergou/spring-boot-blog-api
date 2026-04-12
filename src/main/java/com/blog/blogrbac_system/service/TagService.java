package com.blog.blogrbac_system.service;


import com.blog.blogrbac_system.dto.request.TagRequest;
import com.blog.blogrbac_system.dto.response.TagResponse;
import com.blog.blogrbac_system.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagService{

    public TagResponse createTag(TagRequest request);
    public TagResponse updateTag(Integer id, TagRequest request);
    public void deleteTag(Integer id);
    public List<TagResponse> getAll();


}
