package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.service.PostService;
import com.hanna.first.springbootprj.validation.group.Create;
import com.hanna.first.springbootprj.validation.group.Update;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostApiController {

    private final PostService postService;

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    /**********************************
     *  게시글 조회
     **********************************/
    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    /**********************************
     *  1. 게시글 목록 조회 - 게시판 유형별 조회
     **********************************/
    @GetMapping("/api/v1/posts/boardType/{boardTypeCode}")
    public List<PostResponseDto> getBoardList(@PathVariable BoardType boardTypeCode){
        return postService.getBoardList(boardTypeCode);
    }

    /**********************************
     *  2. 게시글 목록 조회 - 아이디, 게시글 상태(임시저장/공개글)로 조회
     **********************************/
    @GetMapping("/api/v1/posts")
    public List<PostResponseDto> getPostList(@RequestParam String userId,
                                             @RequestParam PostStatus postStatusCode) {
        return postService.getPostList(userId, postStatusCode);
    }

    /**********************************
     *  3. 게시글 등록
     **********************************/
    @PostMapping("/api/v1/posts")
    public void savePost(@Validated(Create.class) @RequestBody PostRequestDto requestDto){
        postService.savePost(requestDto);
    }

    /**********************************
     *  4. 게시글 수정
     **********************************/
    @PatchMapping("/api/v1/posts/{id}")
    public void updatePost(@PathVariable Long id, @Validated(Update.class) @RequestBody PostRequestDto requestDto){
        postService.updatePost(id, requestDto);
    }

    /**********************************
     *  5. 게시글 삭제
     **********************************/
    @DeleteMapping("/api/v1/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
