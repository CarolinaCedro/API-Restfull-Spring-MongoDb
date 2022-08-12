package com.myapi.cirus.resources;

import com.myapi.cirus.domain.User;
import com.myapi.cirus.dto.UserDto;
import com.myapi.cirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/users")

public class UserResource {

    //Pegando todos
    @Autowired
    private UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //Pegando por id especifico
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDto(obj));
    }

    //Update id especifico
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
