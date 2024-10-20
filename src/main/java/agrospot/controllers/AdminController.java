package agrospot.controllers;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.response.ListUserDTO;
import agrospot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping
    public String home(){
        return "Hello Admin!";
    }

    @GetMapping("/user")
    public ResponseEntity<List<ListUserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createNewUser(@RequestBody CreateUserDTO createUserDTO) {
        return (userService.createUser(createUserDTO))
                ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.")
                : ResponseEntity.badRequest().build();

    }

    @GetMapping("/user")
    public ResponseEntity<ListUserDTO> getUserByEmail(@RequestParam("email") String email) {
        ListUserDTO userDto = userService.findUserByEmail(email);
        if(!Objects.isNull(userDto))
            return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/user/{externalId}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID externalId) {
        return (userService.deleteUserByExternalId(externalId))
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
