package com.zaliczenie.apkawebowa.controller;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductControler {

    private ProductService productService;

    public ProductControler(ProductService productService){this.productService=productService;}

    @GetMapping("/produkt")
    public String get(Model model){
        Product product =new Product("Beanie","Prada",49,100,"Opis rzeczy w rzeczy samej", Product.Category.women);
        model.addAttribute("name","olek");
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @GetMapping( "/{id}/{amount}")
    public ResponseEntity<Product> buy(@PathVariable Long id, @PathVariable int amount ) {
        Optional<Product> optionalProduct= Optional.ofNullable(productService.buy(id, amount));
        if (optionalProduct != null) {
            return ResponseEntity.ok(productService.findById(id).get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}

