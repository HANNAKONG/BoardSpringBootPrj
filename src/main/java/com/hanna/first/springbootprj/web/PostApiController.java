package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.service.PostService;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostApiController {

    private final PostService postService;

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    /**********************************
     *  1. 게시글 조회
     **********************************/
    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    /**********************************
     *  2. 게시글 등록
     **********************************/
    @PostMapping("/api/v1/post")
    public void savePost(@RequestBody PostRequestDto requestDto){
        postService.savePost(requestDto);
    }

    /**********************************
     *  3. 게시글 수정
     **********************************/
    @PutMapping("/api/v1/post/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.updatePost(id, requestDto);
    }

    /**********************************
     *  4. 게시글 삭제
     **********************************/
    @DeleteMapping("/api/v1/post/{id}")
    public void deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.deletePost(id, requestDto);
    }


}
