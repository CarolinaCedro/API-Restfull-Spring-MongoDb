package com.myapi.cirus.service;

import com.myapi.cirus.domain.User;
import com.myapi.cirus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User>findAll(){
        return repo.findAll();
    }
}
