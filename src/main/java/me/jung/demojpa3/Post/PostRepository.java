package me.jung.demojpa3.Post;

import me.jung.demojpa3.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository, QuerydslPredicateExecutor<Post> {

}
