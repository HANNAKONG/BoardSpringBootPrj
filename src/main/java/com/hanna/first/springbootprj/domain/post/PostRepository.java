package com.hanna.first.springbootprj.domain.post;

import com.hanna.first.springbootprj.domain.board.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(String userId);

    @Query("SELECT p FROM Post p JOIN p.board b WHERE b.boardTypeCode = :boardTypeCode")
    List<Post> findAllWithPostsByBoardType(@Param("boardTypeCode") BoardType boardTypeCode);

    @Query("SELECT p FROM Post p WHERE p.user.userId = :userId AND p.postStatusCode = :postStatusCode")
    List<Post> findAllByUserIdAndPostStatus(@Param("userId") String userId, @Param("postStatusCode") PostStatus postStatusCode);
}
