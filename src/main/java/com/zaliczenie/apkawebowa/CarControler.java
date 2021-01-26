package com.zaliczenie.apkawebowa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarControler {

    @GetMapping("/car")
    public String get(Model model){

        Car car =new Car("BMW","i8");
        model.addAttribute("name","olek");
        model.addAttribute("car",car);
        return "car";
    }
}
