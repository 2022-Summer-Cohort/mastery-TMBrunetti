package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {


    @Id
    @GeneratedValue
    private long id;

    private String hashtag;

    @ManyToMany (mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
    }
    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", hashtag='" + hashtag + '\'' +
                '}';
    }


    public Hashtag() {
    }

    public long getId() {
        return id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void addPost(Post post){
        posts.add(post);
    }

}
