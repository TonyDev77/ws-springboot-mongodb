package com.tony.workshopmongo.repository;

import com.tony.workshopmongo.domain.Post;
import com.tony.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}