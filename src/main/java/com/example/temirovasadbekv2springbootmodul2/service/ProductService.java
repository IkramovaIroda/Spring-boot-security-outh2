package com.example.temirovasadbekv2springbootmodul2.service;

import com.example.temirovasadbekv2springbootmodul2.dto.ApiResponse;
import com.example.temirovasadbekv2springbootmodul2.dto.ProductDto;
import com.example.temirovasadbekv2springbootmodul2.entity.Product;
import com.example.temirovasadbekv2springbootmodul2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ApiResponse getById(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Bunday id li product mavjud emas", false);
        }
        return new ApiResponse("Mana", true, byId.get());

    }

    public ApiResponse add(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        product.setPrice(productDto.getPrice());
        product.setInfo(productDto.getInfo());
        Product save = productRepository.save(product);
        return new ApiResponse("Qo'shildi", true, save);
    }

    public ApiResponse edit(Integer id, ProductDto productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Bunday id li product mavjud emas", false);
        }
        Product product = byId.get();
        product.setInfo(productDto.getInfo());
        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        product.setPrice(productDto.getPrice());
        Product save = productRepository.save(product);
        return new ApiResponse("O'zgartirildi", true, save);
    }


    public ApiResponse delete(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Buday id li product mavjud emas", false);
        }
        productRepository.deleteById(id);
        return new ApiResponse("O'chirildi", true);
    }
}
