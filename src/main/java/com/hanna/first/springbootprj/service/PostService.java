package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostRepository;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**********************************
     *  1. 게시글 조회
     **********************************/
    public PostResponseDto getPost(Long id){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );

        return new PostResponseDto(entity);
    }

    /**********************************
     *  2. 게시글 등록
     **********************************/
    @Transactional
    public void savePost(PostRequestDto requestDto){
        Post entityDto = requestDto.toEntity();
        postRepository.save(entityDto);
    }

    /**********************************
     *  3. 게시글 수정
     **********************************/
    @Transactional
    public void updatePost(Long id, PostRequestDto requestDto){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );

        entity.update(requestDto.getPostStatusCode(), requestDto.getTitle(), requestDto.getContent());

    }

    /**********************************
     *  4. 게시글 삭제
     **********************************/
    @Transactional
    public void deletePost(Long id, PostRequestDto requestDto){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );
        
        postRepository.delete(entity);
    }
}
