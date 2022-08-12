package com.myapi.cirus.service;

import com.myapi.cirus.domain.Post;
import com.myapi.cirus.domain.User;
import com.myapi.cirus.dto.UserDto;
import com.myapi.cirus.repository.PostRepository;
import com.myapi.cirus.repository.UserRepository;
import com.myapi.cirus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
