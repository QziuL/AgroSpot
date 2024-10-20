package agrospot.controllers;

import agrospot.dtos.request.CreateUserDTO;
import agrospot.dtos.request.ProductRequestDTO;
import agrospot.dtos.response.ListUserDTO;
import agrospot.dtos.response.ProductResponseDTO;
import agrospot.services.ProductService;
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
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(){
        return "Hello Admin!";
    }


    /*
        ====================================
        == Métodos relacionados a User ==
        ====================================
    */
    @GetMapping("/user")
    public ResponseEntity<List<ListUserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<ListUserDTO> getUserByEmail(@PathVariable String email) {
        ListUserDTO userDto = userService.findUserByEmail(email);
        if(!Objects.isNull(userDto))
            return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createNewUser(@RequestBody CreateUserDTO createUserDTO) {
        return (userService.createUser(createUserDTO))
                ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.")
                : ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/user/{externalId}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID externalId) {
        return (userService.deleteUserByExternalId(externalId))
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    /*
        ====================================
        == Métodos relacionados a Produto ==
        ====================================
    */
    @PostMapping("/product")
    public ResponseEntity<Object> createNewProduct(@RequestBody ProductRequestDTO productDto){
        return (productService.createProduct(productDto))
                ? ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully.")
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{externalId}")
    public ResponseEntity<ProductResponseDTO> getProductByExternalId(@PathVariable UUID externalId) {
        ProductResponseDTO productDto = productService.getProductByExternalId(externalId);
        if(!Objects.isNull(productDto))
            return ResponseEntity.ok(productDto);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{externalId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable UUID externalId) {
        return (productService.deleteProductByExternalId(externalId))
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
