package com.e_com.e_com_project.Service;

import com.e_com.e_com_project.Model.Product;
import com.e_com.e_com_project.Repositry.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Product not found with ID: " + id));
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return  repo.save(product);
    }
}
