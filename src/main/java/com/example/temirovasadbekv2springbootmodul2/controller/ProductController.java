package com.example.temirovasadbekv2springbootmodul2.controller;

import com.example.temirovasadbekv2springbootmodul2.dto.ApiResponse;
import com.example.temirovasadbekv2springbootmodul2.dto.ProductDto;
import com.example.temirovasadbekv2springbootmodul2.repository.ProductRepository;
import com.example.temirovasadbekv2springbootmodul2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByID(@PathVariable Integer id) {
        ApiResponse getOneId = productService.getById(id);
        return ResponseEntity.status(getOneId.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(getOneId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody ProductDto productDto) {
        ApiResponse add = productService.add(productDto);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(add);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody ProductDto productDto) {
        ApiResponse edit = productService.edit(id, productDto);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(edit);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = productService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(delete);
    }
}
