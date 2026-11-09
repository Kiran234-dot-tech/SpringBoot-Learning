package com.e_com.e_com_project.Service;

import com.e_com.e_com_project.Model.Product;
import com.e_com.e_com_project.Repositry.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getallProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
//       return  repo.findById(id) //we can also handle , handling null is not good practice
//                            .orElseThrow(()->new RuntimeException("Product not found with Id "+id));
        return  repo.findById(id)
                .orElseThrow(null);
    }
}
