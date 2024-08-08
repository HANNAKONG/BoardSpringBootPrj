package com.hanna.first.springbootprj.domain.user;

import com.hanna.first.springbootprj.domain.post.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> postList;

    /**********************************
     *  기본 생성자
     **********************************/
    protected User() {}

    /**********************************
     *  생성자
     **********************************/
    public User(Long id, String userId, String password, String userName, UserRole userRole) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }

    /**********************************
     *  update method
     **********************************/
    public void update(String password, String userName, UserRole userRole){
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public List<Post> getPostList() {
        return postList;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {

        private Long id;
        private String userId;
        private String password;
        private String userName;
        private UserRole userRole;
        private List<Post> postList;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder postList(List<Post> postList) {
            this.postList = postList;
            return this;
        }

        public User build() {
            return new User(id, userId, password, userName, userRole);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
