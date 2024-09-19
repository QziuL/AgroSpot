package agrospot.controllers;

import agrospot.dtos.request.UserDTO;
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
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<Object> createNewUser(@RequestBody UserDTO userDTO) {
        return (userService.createUser(userDTO))
                ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.")
                : ResponseEntity.badRequest().build();

    }
}
