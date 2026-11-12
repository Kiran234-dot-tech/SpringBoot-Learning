package com.e_com.e_com_project.Controller;

import com.e_com.e_com_project.Model.Product;
import com.e_com.e_com_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        try {
            Product product = service.getProductById(id);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageData){
        try {
            Product product1 = service.addProduct(product,imageData);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProdId(@PathVariable int id){

        try{
            Product product = service.getProductById(id);
            byte[] imageFile = product.getImageData();

            return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType()))
                    .body(imageFile);
        }
        catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
}
