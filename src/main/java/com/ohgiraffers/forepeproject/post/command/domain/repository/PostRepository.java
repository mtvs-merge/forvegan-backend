package com.ohgiraffers.forepeproject.post.command.domain.repository;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    public int getPostNum() {
        return 0;
    }

    public PostCreateController.Post save(PostCreateController.Post post) {
        return post;
    }

    public PostEntity findByPostNum(int postMemberNum) {
        return null;
    }

    public void deleteById(Long postNum) {
    }
}
