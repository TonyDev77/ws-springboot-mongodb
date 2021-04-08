package com.tony.workshopmongo.services;

import com.tony.workshopmongo.domain.Post;
import com.tony.workshopmongo.repository.PostRepository;
import com.tony.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {

        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        //return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDateTime minDate, LocalDateTime maxDate) {
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
