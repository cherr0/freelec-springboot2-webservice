package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 보통 DAO라고 불리는 DB Layer 접근자
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
