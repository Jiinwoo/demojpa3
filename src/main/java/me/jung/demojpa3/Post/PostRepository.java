package me.jung.demojpa3.Post;

import me.jung.demojpa3.MyRepository;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository {

}
