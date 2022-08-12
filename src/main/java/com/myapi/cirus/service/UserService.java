package com.myapi.cirus.service;

import com.myapi.cirus.domain.User;
import com.myapi.cirus.dto.UserDto;
import com.myapi.cirus.repository.UserRepository;
import com.myapi.cirus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    private UserRepository repo;

    //Controller busque todos
    public List<User>findAll(){
        return repo.findAll();
    }

    //Controller busque por id
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //Controller update por id
    public User insert(User obj){
        return repo.insert(obj);
    }


    //Controller Update
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    //Controller Delete
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    //DTO
    public User fromDTO(UserDto objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }


}
