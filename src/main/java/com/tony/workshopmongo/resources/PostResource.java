package com.tony.workshopmongo.resources;

import com.tony.workshopmongo.domain.Post;
import com.tony.workshopmongo.domain.User;
import com.tony.workshopmongo.dto.UserDTO;
import com.tony.workshopmongo.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices postServices;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> postList = postServices.findAll();
//        List<UserDTO> userDTOList = userList.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());

        return ResponseEntity.ok().body(postList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postServices.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
