package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.dto.request.TagRequest;
import com.blog.blogrbac_system.dto.response.TagResponse;
import com.blog.blogrbac_system.entity.Tag;
import com.blog.blogrbac_system.exception.exceptions.AlreadyExistException;
import com.blog.blogrbac_system.mapper.TagMapper;
import com.blog.blogrbac_system.repository.TagsRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName(("Test TagServiceImpl"))
class TagServiceImplTest {

    @Mock
    private  TagsRepository tagsRepository;
    @Mock
    private  TagMapper tagMapper;

    @InjectMocks
    private TagServiceImpl tagService; // that is what we want to test

    private Tag tag;
    private TagRequest tagRequestCreate;
    private TagRequest tagRequestUpdate;
    private TagResponse tagResponse;

    @BeforeEach
    void setUp(){
        this.tagRequestCreate = TagRequest.builder()
                .name("innovation")
                .description("innovation for test")
                .is_active(true)
                .build();
        this.tag = Tag.builder()
                .id(1)
                .name("innovation")
                .description("innovation for test")
                .isActive(true)
                .build();
        this.tagResponse = TagResponse.builder()
                .id(1)
                .name("innovation")
                .description("innovation for test")
                .createdAt(Instant.now())
                .isActive(true)
                .articles(new LinkedList<>())
                .build();
        // == cas Update
        this.tagRequestUpdate = TagRequest.builder()
                .name("technology")
                .description("technology for test")
                .is_active(true)
                .build();
    }
    @Nested
    @DisplayName("Create tag Test")
    class CreateTagTest{

        @Test
        @DisplayName("Should Create Tag successfully when request is valid ")
        void shouldCreateTagSuccessfully_whenTagNameNoteExists(){
            // Given
            when(tagsRepository.existsByName(tagRequestCreate.getName())).thenReturn(false);
            when(tagsRepository.save(any(Tag.class))).thenReturn(tag);
            when(tagMapper.apply(tag)).thenReturn(tagResponse);
            // when
            TagResponse response = tagService.createTag(tagRequestCreate);
            // then
            assertNotNull(response);
            assertEquals(tagResponse, response);
            verify(tagsRepository).existsByName(tagRequestCreate.getName());
            verify(tagsRepository).save(any(Tag.class));
            verify(tagMapper).apply(tag);
        }
        @Test
        @DisplayName("Test not successfully ")
        void shouldThrowAlreadyExistException_whenTagNameExists(){
            when(tagsRepository.existsByName(tagRequestCreate.getName())).thenReturn(true);

            assertThrows(AlreadyExistException.class,
                    () -> tagService.createTag(tagRequestCreate));
            verify(tagsRepository).existsByName(tagRequestCreate.getName());
            verify(tagsRepository, never()).save(any());
            verifyNoInteractions(tagMapper);
        }

    }
    @Nested
    @DisplayName("Update Taf Test")
    class updateTagTest{

        @Test
        @DisplayName("Should successfully test id exists and tag name not exists")
        void shouldUpdateTagSuccessfully(){
            Integer id = 1;
            when(tagsRepository.findById(id)).thenReturn(Optional.of(tag));



        }
        @Test
        @DisplayName("Should throw AlreadyExistsException when id exists and tag name exists")
        void shouldThrowAlreadyExistException(){

        }

    }
}