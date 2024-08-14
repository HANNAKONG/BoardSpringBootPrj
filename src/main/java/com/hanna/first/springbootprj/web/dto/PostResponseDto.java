package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostResponseDto {

    private Long id;
    private PostStatus postStatusCode;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    //USER
    private String userId;
    private String userName;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.postStatusCode = entity.getPostStatusCode();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();

        if (entity.getUser() != null) {
            this.userId = entity.getUser().getUserId();
            this.userName = entity.getUser().getUserName();
        }
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

    public String getCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdDate.format(formatter);
    }

    public String getModifiedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return modifiedDate.format(formatter);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
