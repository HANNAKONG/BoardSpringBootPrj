package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.service.PostService;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostApiController {

    private final PostService postService;

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    /**********************************
     *  테스트 필요
     *  게시글 조회
     **********************************/
    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    /**********************************
     *  1. 게시글 목록 조회 - 게시판 유형별 조회
     **********************************/
    @GetMapping("/api/v1/boardList/{boardTypeCode}")
    public List<PostResponseDto> getBoardList(@PathVariable BoardType boardTypeCode){
        return postService.getBoardList(boardTypeCode);
    }

    /**********************************
     *  테스트 필요
     *  2. 게시글 목록 조회 - 아이디로 조회(임시저장/공개글)
     **********************************/
    @GetMapping("/api/v1/postList")
    public List<Post> getPostList(@RequestBody PostRequestDto requestDto) {
        System.out.println("controller========> "+requestDto.getUserId()+" "+requestDto.getPostStatusCode());
        return postService.getPostList(requestDto);
    }

    /**********************************
     *  3. 게시글 등록
     **********************************/
    @PostMapping("/api/v1/post")
    public void savePost(@RequestBody PostRequestDto requestDto){
        postService.savePost(requestDto);
    }

    /**********************************
     *  4. 게시글 수정
     **********************************/
    @PutMapping("/api/v1/post/{id}")
    public void updatePost(@RequestBody PostRequestDto requestDto){
        postService.updatePost(requestDto);
    }

    /**********************************
     *  5. 게시글 삭제
     **********************************/
    @DeleteMapping("/api/v1/post/{id}")
    public void deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.deletePost(id, requestDto);
    }



}
