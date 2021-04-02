package com.tony.workshopmongo.resources;

import com.tony.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "mara@mail.com");
        User alex = new User("2", "Alex Brown", "alex@mail.com");
        List<User> usersList = new ArrayList<>();
        usersList.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(usersList);
    }
}
