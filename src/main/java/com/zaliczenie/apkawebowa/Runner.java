package com.zaliczenie.apkawebowa;

import com.zaliczenie.apkawebowa.model.Client;
import com.zaliczenie.apkawebowa.model.Product;
import com.zaliczenie.apkawebowa.repository.ProductRepository;
import com.zaliczenie.apkawebowa.service.ClientService;
import com.zaliczenie.apkawebowa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ClientService clientService;

    @Override
    public void run(String... args) throws Exception {

        productService.save(new Product("Beanie", "Prada", 49.99f, 100, "Lorem " +
                "ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore" +
                " magna aliqua. Ut enim ad minim veniam,  quis nostrud exercitation.", Product.Category.women));

        productService.save(new Product("Coat", "Tress", 599.99f, 35, "Lorem" +
                " Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the" +
                " industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of" +
                " type and scrambled it to make a type specimen book.", Product.Category.women));

        productService.save(new Product("Jacket", "Mfashion", 399.99f, 60, "In " +
                "interdum ex non metus tincidunt, ac bibendum erat varius. Morbi non neque dui. Praesent massa justo, " +
                "condimentum eget est ut, consectetur vehicula ipsum. Aenean mattis arcu et arcu aliquet, ac venenatis " +
                "risus posuere.", Product.Category.women));

        productService.save(new Product("Dress", "Mfashion", 299.99f, 120, "Nunc" +
                " sit amet lacinia urna. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus" +
                " mus. Praesent lacus leo, mollis sit amet nunc ac, iaculis ultricies ipsum. Quisque eu pellentesque ex," +
                " tempor facilisis felis.", Product.Category.women));

        productService.save(new Product("Trainers", "Nike", 899.99f, 80, "Class " +
                "aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque dapibus " +
                "finibus tempus. Cras commodo luctus vestibulum.", Product.Category.men));

        productService.save(new Product("Bag", "LuiV", 1399.99f, 20, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.accessory));

        productService.save(new Product("T-shirt Basic", "LuiV", 99.99f, 20, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.women));

        productService.save(new Product("T-shirt Another", "Lui", 199.99f, 20, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.women));

        productService.save(new Product("T-shirt E", "Lui", 399.99f, 20, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis " +
                "dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.men));

        productService.save(new Product("T-shirt Fancy", "Lui", 2399.99f, 25, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.women));

        productService.save(new Product("Difrent Coat", "Tress", 1599.99f, 45, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.women));

        productService.save(new Product("Yet another Coat", "Lui", 3999.99f, 15, "Mauris" +
                " non enim porta libero ultrices luctus. Duis elementum sem vitae ligula convallis, a lobortis turpis" +
                " dictum. Interdum et malesuada fames ac ante ipsum primis in faucibus.", Product.Category.women));

        clientService.save(new Client("marko", "Marek", "Kowalski"));
        clientService.save(new Client("zbyszko", "Zbyszek", "Nowak"));
        clientService.save(new Client("jurko", "Jurek", "Lewandowski"));
        clientService.save(new Client("bart", "Bartosz", "Klein"));
        clientService.save(new Client("matix", "Mateusz", "Piernicki"));
        clientService.save(new Client("robo", "Robert", "Iksinski"));

    }
}
