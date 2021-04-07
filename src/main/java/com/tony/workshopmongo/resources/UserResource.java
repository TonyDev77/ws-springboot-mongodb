package com.tony.workshopmongo.resources;

import com.tony.workshopmongo.domain.User;
import com.tony.workshopmongo.dto.UserDTO;
import com.tony.workshopmongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> userList = userServices.findAll();
        List<UserDTO> userDTOList = userList.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());

       return ResponseEntity.ok().body(userDTOList);
    }
}
