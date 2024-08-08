package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;

public class PostResponseDto {

    private Long id;
    private PostStatus postStatusCode;
    private String title;
    private String content;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.postStatusCode = entity.getPostStatusCode();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public PostStatus getPostStatusCode() {
        return postStatusCode;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
