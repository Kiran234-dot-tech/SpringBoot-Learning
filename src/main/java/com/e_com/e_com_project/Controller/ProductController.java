package com.e_com.e_com_project.Controller;

import com.e_com.e_com_project.Model.Product;
import com.e_com.e_com_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello Spring";
    }

    @GetMapping("/products")
    //  handling the Exceptions ,status passing
    public ResponseEntity<List<Product>> getallProducts(){
        List<Product> products =  service.getallProducts();
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getProductById(id);

        if(product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
