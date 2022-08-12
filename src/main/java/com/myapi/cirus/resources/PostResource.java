package com.myapi.cirus.resources;

import com.myapi.cirus.domain.Post;
import com.myapi.cirus.domain.User;
import com.myapi.cirus.dto.UserDto;
import com.myapi.cirus.service.PostService;
import com.myapi.cirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/posts")

public class PostResource {

    //Pegando todos
    @Autowired
    private PostService service;


    //Pegando por id especifico
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
