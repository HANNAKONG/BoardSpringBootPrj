package com.hanna.first.springbootprj.domain.board;

import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByBoardTypeCodeAndPostStatusCode(BoardRequestDto requestDto);
}