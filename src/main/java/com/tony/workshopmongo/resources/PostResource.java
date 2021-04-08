package com.tony.workshopmongo.resources;

import com.tony.workshopmongo.domain.Post;
import com.tony.workshopmongo.domain.User;
import com.tony.workshopmongo.dto.UserDTO;
import com.tony.workshopmongo.resources.util.MyURL;
import com.tony.workshopmongo.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping(value = "/titleseach")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

        text = MyURL.decodeParam(text);
        List<Post> posts = postServices.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {

        text = MyURL.decodeParam(text);
        LocalDate dateMin = MyURL.convertDate(minDate, LocalDate.now());
        LocalDate dateMax = MyURL.convertDate(maxDate, LocalDate.now());
        List<Post> posts = postServices.fullSearch(text, dateMin, dateMax);

        return ResponseEntity.ok().body(posts);
    }
}
