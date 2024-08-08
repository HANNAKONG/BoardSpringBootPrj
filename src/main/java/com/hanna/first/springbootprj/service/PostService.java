package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardRepository;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostRepository;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRepository;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public PostService(final PostRepository postRepository, final BoardRepository boardRepository, final UserRepository userRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    /**********************************
     *  1. 게시글 조회
     **********************************/
    public PostResponseDto getPost(final Long id){
        final Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );

        return new PostResponseDto(entity);
    }

    /**********************************
     *  1. 게시글 목록 조회 - 게시판 유형별 조회
     **********************************/
    @Transactional(readOnly = true)
    public List<PostResponseDto> getBoardList(final BoardType boardTypeCode){
        List<Post> boardList = postRepository.findAllWithPostsByBoardType(boardTypeCode);

        return boardList.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    /**********************************
     *  2. 게시글 목록 조회 - 아이디로 조회(임시저장/공개글)
     **********************************/
    public List<Post> getPostList(final PostRequestDto requestDto) {
        Board board = boardRepository.findById(requestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid board ID: " + requestDto.getBoardId()));
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + requestDto.getUserId()));
        System.out.println("service1111========> "+requestDto.getUserId()+" "+requestDto.getPostStatusCode());

        PostStatus postStatusCode = requestDto.getPostStatusCode();
        Post entity = requestDto.toEntity(board, user);
        String userId = entity.getUser().getUserId();
        System.out.println("service2222222========> "+userId+" "+postStatusCode);
        return postRepository.findByUserIdAndPostStatus(userId, postStatusCode);
    }

    /**********************************
     *  3. 게시글 등록
     **********************************/
    @Transactional
    public void savePost(final PostRequestDto requestDto){
        Board board = boardRepository.findById(requestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid board ID: " + requestDto.getBoardId()));
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + requestDto.getUserId()));

        final Post entityDto = requestDto.toEntity(board, user);
        postRepository.save(entityDto);
    }

    /**********************************
     *  4. 게시글 수정
     **********************************/
    @Transactional
    public void updatePost(final PostRequestDto requestDto){
        final Post entity = postRepository.findById(requestDto.getId()).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ requestDto.getId())
        );

        entity.update(requestDto.getPostStatusCode(), requestDto.getTitle(), requestDto.getContent());

    }

    /**********************************
     *  5. 게시글 삭제
     **********************************/
    @Transactional
    public void deletePost(final Long id, final PostRequestDto requestDto){
        final Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );
        
        postRepository.delete(entity);
    }

}
