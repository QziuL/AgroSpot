package agrospot.controllers;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.response.ListUserDTO;
import agrospot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ListUserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

//    @PostMapping
//    public ResponseEntity<Object> createNewUser(@RequestBody CreateUserDTO createUserDTO) {
//        return (userService.createUser(createUserDTO))
//                ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.")
//                : ResponseEntity.badRequest().build();
//
//    }
}
