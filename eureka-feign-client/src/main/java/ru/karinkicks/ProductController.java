package ru.karinkicks;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class ProductController {

    @Autowired
    private final ProductClient productClient;

    @PostMapping("/products")
    public String create(ProductDto productDto) {
        productClient.saveProduct(productDto);
        return "redirect:/all_products";
    }

    @GetMapping("/products")
    public String add(Model model) {
        model.addAttribute("product", new ProductDto());
        return "products";
    }


    @GetMapping("/all_products")
    public String showProductRepository(Model uiModel) {
        uiModel.addAttribute("products", productClient.findAllProducts());
        return "all_products";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("product", productClient.getById(id));
        return "redirect:/all_products";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable(value = "id") Long id) {
        productClient.deleteById(id);
        return "redirect:/all_products";
    }

}
