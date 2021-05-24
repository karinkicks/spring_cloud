package ru.karinkicks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<ProductDto> findProductDtoById(Long id) {
        return productRepository.findById(id).map((p)->{
            ProductDto productDto = new ProductDto();
            productDto.setId(p.getId());
            productDto.setPrice(p.getPrice());
            productDto.setName(p.getName());
            return productDto;
        });
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map((p)->{
            ProductDto productDto = new ProductDto();
            productDto.setId(p.getId());
            productDto.setPrice(p.getPrice());
            productDto.setName(p.getName());
            System.out.println(p.getName());
            return productDto;
        }).collect(Collectors.toList());
    }

    public Product save(ProductDto productDto) {
        Product p = new Product();
        p.setId(productDto.getId());
        p.setName(productDto.getName());
        p.setPrice(productDto.getPrice());
        return productRepository.save(p);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
