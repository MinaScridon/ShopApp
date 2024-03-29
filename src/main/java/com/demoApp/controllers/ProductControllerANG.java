package com.demoApp.controllers;

import com.demoApp.entities.Product;
import com.demoApp.exeption.ResourceNotFoundException;
import com.demoApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductControllerANG {

    //HTTP Endpoints: GET, POST, Put, DELETE
    private final ProductService productService;

    /*
        public ProductControllerANG(ProductService productService) {
            this.productService = productService;
        }
    */
    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findByID(@PathVariable(name = "id") Long id){
        Product product = productService.findById(id).orElseThrow(()->new ResourceNotFoundException("Product with id " + id + " not found."));
      //  return ResponseEntity.ok(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/productFound/{name}")
    public ResponseEntity<List<Product>> findAllByName(@PathVariable(name = "name") String name){
        List<Product> products = productService.findAllByName(name);

        if (products.size() == 0){
            throw new ResourceNotFoundException("The list products doesn't contain any product with name " + name);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        Product newProduct = productService.addProduct(prod);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/editProductFound/{id}")
    public ResponseEntity<Product> editProductFoundByID(@PathVariable(value = "id") Long id, @RequestBody Product prodFRomUser){
        Product prodFromDB = productService.findById(id).orElseThrow(()->new ResourceNotFoundException("Product with id " + id + " not found."));
        prodFromDB.setName(prodFRomUser.getName());
        prodFromDB.setDescription(prodFRomUser.getDescription());
        prodFromDB.setCategory(prodFRomUser.getCategory());
        prodFromDB.setPrice(prodFRomUser.getPrice());

        Product editedProduct = productService.editProduct(prodFromDB);
        return ResponseEntity.ok(editedProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProductByID(@PathVariable("id") Long id){
        productService.findById(id).orElseThrow(()->new ResourceNotFoundException("Product with id " + id + " not found."));
        productService.deleteProductByID(id);

        return new ResponseEntity<>("Product with id " + id + " has been deleted successfully!", HttpStatus.OK);
    }
}
