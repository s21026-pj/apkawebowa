package com.zaliczenie.apkawebowa;

import com.zaliczenie.apkawebowa.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductControler {

    @GetMapping("/produkt")
    public String get(Model model){
        Product product =new Product("BMW","i8");
        model.addAttribute("name","olek");
        model.addAttribute("product", product);
        return "product";
    }
}

