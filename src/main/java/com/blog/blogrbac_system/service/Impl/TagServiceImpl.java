package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.dto.request.TagRequest;
import com.blog.blogrbac_system.dto.response.TagResponse;
import com.blog.blogrbac_system.entity.Tag;
import com.blog.blogrbac_system.exception.exceptions.AlreadyExistException;
import com.blog.blogrbac_system.exception.exceptions.TagNotFoundException;
import com.blog.blogrbac_system.mapper.TagMapper;
import com.blog.blogrbac_system.repository.TagsRepository;
import com.blog.blogrbac_system.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagsRepository tagsRepository;
    private final TagMapper tagMapper;

    @Override
    public TagResponse createTag(TagRequest request) {
        validateExistTag(request.getName(), null);
        Tag tag = Tag.builder()
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(Instant.now())
                .isActive(true)
                .build();
        return tagMapper.apply(tagsRepository.save(tag));
    }

    @Override
    public TagResponse updateTag(Integer id, TagRequest request) {
        Tag tag = this.get(id);
        this.validateExistTag(request.getName(), tag.getId());
        tag.setName(request.getName());
        tag.setDescription(request.getDescription());
        if(request.getIsActive() != null){
            tag.setActive(request.getIsActive());
        }
        return tagMapper.apply(tagsRepository.save(tag));
    }

    @Override
    public void deleteTag(Integer id) {
        tagsRepository.delete(this.get(id));
    }

    @Override
    public List<TagResponse> getAll() {  // TODO add pagination concept
        return tagsRepository.findAll()
                .stream()
                .map(tagMapper)
                .toList();
    }

    private Tag get(Integer id){
        return tagsRepository.findById(id).orElseThrow(
                () -> new TagNotFoundException(id)
        );
    }
    private void validateExistTag(String name, Integer id){
        boolean exist;
        if(id == null){
            exist = tagsRepository.existsByName(name);
        }else{
            exist = tagsRepository.existsByNameAndIdNot(name, id);
        }
        if(exist){
            throw new AlreadyExistException("Tag", name);
        }
    }
}
