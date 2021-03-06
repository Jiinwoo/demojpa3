package me.jung.demojpa3.Post;


import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void crud() {
        Post post = new Post();
        post.setContent("hi jinwoo");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.content.containsIgnoreCase("Hi");
        Optional<Post> one = postRepository.findOne(predicate);
        assertThat(one).isNotEmpty();
    }

//    @Test
//    public void event(){
//        Post post = new Post();
//        post.setContent("event");
//        PostPublishedEvent event = new PostPublishedEvent(post);
//
//        applicationContext.publishEvent(event);
//    }

//    @Test
//    public void crud() {
//        Post post = new Post();
//        post.setContent("hibernate");
//
//        assertThat(postRepository.contains(post)).isFalse();
//
//        postRepository.save(post.publish());
//        assertThat(postRepository.contains(post)).isTrue();
//
//
////        postRepository.findMyPost();
//        postRepository.delete(post);
//        postRepository.flush();
//    }

}