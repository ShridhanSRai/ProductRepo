package com.cg.micro.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.micro.demo.entity.Product;
import com.cg.micro.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts(){
        return repo.findAll();
	}
	public List<Product> listAll() {


			List<Product> products= repo.findAll();

			System.out.println(products);

			return products;

		}
	
	@Autowired
	ProductRepository productrepo;

	public Optional<Product> getProduct(int id){

		Optional<Product> p=productrepo.findById(id);

		return p;
	}
	public Product createProduct(Product product) {

			return repo.save(product);

		}	
	public Map<String,Boolean> removeProduct(long id){
	    repo.deleteById((int) id);
	    Map<String,Boolean> status = new HashMap<>();
	    status.put("Deleted successfully",Boolean.TRUE);
	    return status;
	}
	public String updateProduct(Integer productId, Product newProduct) {

			Optional<Product> existingProduct = repo.findById(productId);

			if(existingProduct.isPresent()) {

				Product foundProduct = existingProduct.get();

				foundProduct.setName(newProduct.getName());

				foundProduct.setPrice(newProduct.getPrice());

				repo.save(foundProduct);
	 
				return "product Updated";

			}

			return "product Not Updated";


		}
}
	
