package com.tony.workshopmongo.repository;

import com.tony.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

//    List<Post> findByTitleContaining(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}