package com.e_com.e_com_project.Repositry;

import com.e_com.e_com_project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
