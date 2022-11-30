package com.udemy.workshopmongodb.config;

import com.udemy.workshopmongodb.domain.Post;
import com.udemy.workshopmongodb.domain.User;
import com.udemy.workshopmongodb.dto.AuthorDTO;
import com.udemy.workshopmongodb.dto.CommentDTO;
import com.udemy.workshopmongodb.repositories.PostRepository;
import com.udemy.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Nelio Alves", "nelio.ifm@gmail.com");
        User u2 = new User(null, "Maria Brown", "maria@gmail.com");
        User u3 = new User(null, "Alex Green", "alex@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));

        userRepository.save(u1);

        CommentDTO c1 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(u2));
        CommentDTO c3 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(u3));


        p1.getComments().addAll(Arrays.asList(c1, c3));
        p2.getComments().add(c2);

        postRepository.saveAll(Arrays.asList(p1, p2));

    }
}