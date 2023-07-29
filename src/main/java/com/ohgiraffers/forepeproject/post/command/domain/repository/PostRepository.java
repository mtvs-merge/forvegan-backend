package com.ohgiraffers.forepeproject.post.command.domain.repository;


import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
//    public int getPostNum() {
//        return 0;
//    }
//
//    public PostCreateController.Post save(PostCreateController.Post post) {
//        return post;
//    }
//
//    public PostEntity findByPostNum(int postMemberNum) {
//        return null;
//    }
//
//    public void deleteById(Long postNum) {
//    }

    PostEntity<P> findByPostNum(int postNum);

//    void findById(Long postNum);
}
