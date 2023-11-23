package com.cg.micro.demo.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.micro.demo.entity.Product;
import com.cg.micro.demo.service.ProductService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService service;
	
//    @GetMapping("/products")
//    public String getProducts(){
//        return "Products are displayed here ";
//    }
   // @GetMapping("/products")
	@GetMapping(path="/products",produces= {MediaType.APPLICATION_JSON_VALUE})
	//@GetMapping(path="/products",produces= {MediaType.APPLICATION_ATOM_XML_VALUE})
    	public List<Product>viewProductList() {

    		List<Product> listproducts = service.listAll();

    		return listproducts;

    	}
	@PostMapping("/products")

		public Product createEmployee(@Valid @RequestBody Product newProduct) {

			return service.createProduct(newProduct);

		}
	

	@GetMapping("/products/{pid}")

	public Optional<Product> findByProduct(@PathVariable int pid) {

		return service.getProduct(pid);

	}	
	@DeleteMapping("/products/delete/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable("id") int id){
	    return service.removeProduct(id);

	}
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable(value="id") Integer id, @Valid @RequestBody Product newProduct) {
		return service.updateProduct(id, newProduct);

	}
}
 