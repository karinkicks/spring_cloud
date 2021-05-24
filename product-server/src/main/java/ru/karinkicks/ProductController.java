package ru.karinkicks;

import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface ProductController {

    @PostMapping( "/")
    ProductDto saveProduct(@RequestBody ProductDto product);

    @PutMapping("/")
    ProductDto updateProduct(@RequestBody ProductDto product);

    @GetMapping
    List<ProductDto> findAllProducts();

    @GetMapping( "/{id}")
    ProductDto getById(@PathVariable(value = "id") Long id) ;

    @DeleteMapping( "/{id}")
    void deleteById(@PathVariable Long id);
}
