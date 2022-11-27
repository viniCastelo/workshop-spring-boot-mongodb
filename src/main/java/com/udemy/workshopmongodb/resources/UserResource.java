package com.udemy.workshopmongodb.resources;

import com.udemy.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User vinicius = new User(1L,"Vinícius","vinicius@gmail.com");
        User karen = new User(2L,"Karen","karen@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(vinicius, karen));
        return ResponseEntity.ok().body(list);
    }

}