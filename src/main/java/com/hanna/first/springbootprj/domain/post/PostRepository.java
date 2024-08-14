package com.hanna.first.springbootprj.domain.post;

import com.hanna.first.springbootprj.domain.board.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(String userId);

    List<Post> findAllByBoard_BoardTypeCode(@Param("boardTypeCode") BoardType boardTypeCode);

    @Query("SELECT p FROM Post p JOIN FETCH p.user WHERE p.user.userId = :userId AND p.postStatusCode = :postStatusCode")
    List<Post> findAllByUserIdAndPostStatus(@Param("userId") String userId, @Param("postStatusCode") PostStatus postStatusCode);
}
