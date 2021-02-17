package com.lrsrodrigues.user.resources;

import com.lrsrodrigues.user.dto.UserDTO;
import com.lrsrodrigues.user.entities.User;
import com.lrsrodrigues.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users  = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{user.id}")
    public ResponseEntity<User> findById(@PathVariable("user.id") Integer id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTORequest) {
        User user = userService.insert(userDTORequest);
        return ResponseEntity.created(uri(user.getId())).body(user);
    }

    @PutMapping(value = "/{user.id}")
    public ResponseEntity<User> update(@PathVariable("user.id") Integer id, @RequestBody UserDTO userDTORequest) {
        User user = userService.update(id, userDTORequest);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{user.id}")
    public ResponseEntity<Void> delete(@PathVariable("user.id") Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI uri(Integer id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return uri;
    }
}

