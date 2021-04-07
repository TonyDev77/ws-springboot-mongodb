package com.tony.workshopmongo.services;

import com.tony.workshopmongo.domain.User;
import com.tony.workshopmongo.dto.UserDTO;
import com.tony.workshopmongo.repository.UserRepository;
import com.tony.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Obj não encontrado"));
    }


    //...
    public User fromDTO(UserDTO userDTO) {

        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public User insertUser(UserDTO userDTO) {
        User user = fromDTO(userDTO);
        User userExists = userRepository.findByEmail(user.getEmail());

        if (userExists != null && !userExists.equals(user)) {
            throw new ObjectNotFoundException("Já existe um cliente cadastrado com este email");
        }

        userRepository.save(user);

        return user;
    }

    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new ObjectNotFoundException("Não existe o id: " + id + " no banco de dados!");
        }
        userRepository.deleteById(id);
    }
}
