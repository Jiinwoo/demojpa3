package me.jung.demojpa3.Post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

//    @Bean
//    public PostListener postListener (){
//        return new PostListener();
//    }

    @Bean
    public ApplicationListener<PostPublishedEvent> postListener2() {
        return event -> {
            System.out.println("----------------");
            System.out.println(event.getPost() + "is published!");
            System.out.println("----------------");
        };
    }

}
