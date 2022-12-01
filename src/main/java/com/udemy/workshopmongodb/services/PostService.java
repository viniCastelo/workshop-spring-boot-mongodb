package com.udemy.workshopmongodb.services;

import com.udemy.workshopmongodb.domain.Post;
import com.udemy.workshopmongodb.repositories.PostRepository;
import com.udemy.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        List<Post> list = repository.findAll();
        return list;
    }

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}