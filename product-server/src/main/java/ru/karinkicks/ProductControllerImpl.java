package ru.karinkicks;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {

    private ProductService productService;

    @Override
    @PostMapping( "/")
    public ProductDto saveProduct(@RequestBody ProductDto product){
        productService.save(product);
        return product;
    }

    @Override
    @PutMapping("/")
    public ProductDto updateProduct(@RequestBody ProductDto product) {
        productService.save(product);
        return product;
    }

    @Override
    @GetMapping
    public List<ProductDto> findAllProducts(){
        return productService.findAll();
    }

    @Override
    @GetMapping( "/{id}")
    public ProductDto getById(@PathVariable(value = "id") Long id) {
        return productService.findProductDtoById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @DeleteMapping( "/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
