package com.zaliczenie.apkawebowa.controller;

import com.zaliczenie.apkawebowa.model.Ordered;
import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.service.OrderedService;
import com.zaliczenie.apkawebowa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderedService orderedService;

    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show/{id}")
    public String get(Model model, @PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            Ordered ordered = new Ordered(); //optionalProduct.get().getId()
            model.addAttribute("name", "olek");
            model.addAttribute("product", optionalProduct.get());
            model.addAttribute("ordered", ordered);
            return "product";
        } else {
            return "Not_Found";
        }
    }

    @GetMapping("/page/{pageNumber}")
    public String filterByPrice(Model model, @PathVariable int pageNumber) {
        Page<Product> productList = productService.filterByPrice(pageNumber);
        int pageCount = (int) productList.getTotalElements() / 4;
        model.addAttribute("productList", productList);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("pageNumber", pageNumber);
        return "home2";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @GetMapping("/sold/{id}/{amount}")
    public ResponseEntity<String> sell(@PathVariable Long id, @PathVariable int amount) {
        int leftAmount = productService.sell(id, amount);
        return ResponseEntity.ok("Zostało" + leftAmount);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdate(
            @RequestBody Map<String, Object> updates,
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.partialUpdateById(updates, id));
    }

    @GetMapping("/order/{id}")
    public String greetingSubmit(@ModelAttribute Ordered ordered, Model model, @PathVariable Long id, @RequestParam int orderAmount) {
        if (orderedService.placeOrder(id, ordered)) {
            String productName = productService.findById(id).get().getProductName();
            model.addAttribute("ordered", ordered);
            model.addAttribute("productName", productName);
            return "result";
        } else {
            String status = "Ordered amount exceeds stock amount or user login incorrect";
            model.addAttribute("Status", status);
            return "Too_Much";
        }
    }
}

