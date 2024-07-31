package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardRepository;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostRepository;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    public BoardService(BoardRepository boardRepository, PostRepository postRepository) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }
    
    /**********************************
     *  1. 게시글 목록 조회
     **********************************/
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoardList(BoardRequestDto requestDto){

        //게시글 상태 = 게시인 글만 조회
        BoardRequestDto requestDtoSet = BoardRequestDto.builder()
                .boardTypeCode(requestDto.getBoardTypeCode())
                .postStatusCode(PostStatus.PUBLISHED.getCode())
                .title(requestDto.getTitle())
                .authorId(requestDto.getAuthorId())
                .build();

        List<Board> boardList = boardRepository.findAllByBoardTypeCodeAndPostStatusCode(requestDtoSet);

        List<BoardResponseDto> responseList = new ArrayList<>();
        for (Board entityDto : boardList) {
            responseList.add(new BoardResponseDto(entityDto));
        }

        return responseList;
    }

    /**********************************
     *  2. 게시글 조회
     **********************************/
    public PostResponseDto getPost(Long id){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );

        return new PostResponseDto(entity);
    }

    /**********************************
     *  3. 게시글 등록
     **********************************/
    @Transactional
    public void savePost(PostRequestDto requestDto){
        Post entityDto = requestDto.toEntity();
        postRepository.save(entityDto);
    }

    /**********************************
     *  4. 게시글 수정
     **********************************/
    @Transactional
    public void updatePost(Long id, PostRequestDto requestDto){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );

        entity.update(requestDto.getPostStatusCode(), requestDto.getTitle(), requestDto.getContent());

    }

    /**********************************
     *  5. 게시글 삭제
     **********************************/
    @Transactional
    public void deletePost(Long id, PostRequestDto requestDto){
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id)
        );
        
        postRepository.delete(entity);
    }
}
