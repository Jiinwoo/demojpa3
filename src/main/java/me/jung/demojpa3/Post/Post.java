package me.jung.demojpa3.Post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
public class Post extends AbstractAggregateRoot<Post> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Post publish() {

        this.registerEvent(new PostPublishedEvent(this));

        return this;
    }
}
