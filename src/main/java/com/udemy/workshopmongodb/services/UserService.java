package com.udemy.workshopmongodb.services;

import com.udemy.workshopmongodb.domain.User;
import com.udemy.workshopmongodb.dto.UserDTO;
import com.udemy.workshopmongodb.repositories.UserRepository;
import com.udemy.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public void deleteById(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User entity = findById(obj.getId());
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

}