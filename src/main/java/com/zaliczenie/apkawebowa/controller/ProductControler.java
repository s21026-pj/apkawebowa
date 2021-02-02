package com.zaliczenie.apkawebowa.controller;

import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
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
    private ProductRepository productRepository;

    public ProductControler(ProductService productService){this.productService=productService;}

    @GetMapping("/show/{id}")
    public String get(Model model,@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()) {
            model.addAttribute("name", "olek");
            model.addAttribute("product",optionalProduct.get());
            return "product";
        }else {
            return "Not_Found";
        }
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


//    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdate(
            @RequestBody Map<String, Object> updates,
            @PathVariable("id") Long id){
        return ResponseEntity.ok(productService.partialUpdateById(updates, id));
    }


}
