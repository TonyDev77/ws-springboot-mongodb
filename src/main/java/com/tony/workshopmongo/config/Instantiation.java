//package com.tony.workshopmongo.config;
//
//import com.tony.workshopmongo.domain.Post;
//import com.tony.workshopmongo.domain.User;
//import com.tony.workshopmongo.dto.AuthorDTO;
//import com.tony.workshopmongo.dto.CommentDTO;
//import com.tony.workshopmongo.repository.PostRepository;
//import com.tony.workshopmongo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@Configuration
//public class Instantiation implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PostRepository postRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        userRepository.deleteAll();
//        postRepository.deleteAll();
//
//        User maria = new User(null, "Maria Brown", "maria@gmail.com");
//        User alex = new User(null, "Alex Green", "alex@gmail.com");
//        User bob = new User(null, "Bob Grey", "bob@gmail.com");
//
//        userRepository.saveAll(Arrays.asList(maria, alex, bob));
//
//        Post post1 = new Post(null, LocalDate.now(), "Partiu viagem", "Vou viajar para SP, abcs!!!", new AuthorDTO(maria));
//        Post post2 = new Post(null, LocalDate.now(), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
//
//        CommentDTO c1 = new CommentDTO("Boa viagem, mano", LocalDate.now(), new AuthorDTO(alex));
//        CommentDTO c2 = new CommentDTO("Aproveite", LocalDate.now(), new AuthorDTO(bob));
//        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.now(), new AuthorDTO(alex));
//        post1.getComments().addAll(Arrays.asList(c1, c2));
//        post1.getComments().addAll(Arrays.asList(c3));
//
//        postRepository.saveAll(Arrays.asList(post1, post2));
//
//        maria.getPosts().addAll(Arrays.asList(post1, post2));
//
//        userRepository.save(maria);
//    }
//}
