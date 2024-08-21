package com.example.siva.Ecommerce.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.siva.Ecommerce.model.Product;
import com.example.siva.Ecommerce.repo.ProductRepo;
@Service

public class ProductService {

    @Autowired
    ProductRepo Repo;

    public List<Product> getAllProducts() {
        return Repo.findAll();
        
    }

    public Product getById(int id){
        return Repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return Repo.save(product);
    }
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageDate(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return Repo.save(product);
    }

    public void deleteProduct(int id) {
        Repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return Repo.searchProducts(keyword);
    }

}
