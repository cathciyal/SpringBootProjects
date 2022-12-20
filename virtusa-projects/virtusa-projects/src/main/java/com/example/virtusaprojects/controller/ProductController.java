package com.example.virtusaprojects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.virtusaprojects.entity.Product;
import com.example.virtusaprojects.repository.ProductRepository;
import com.example.virtusaprojects.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
@SessionAttributes("name")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/")
	@ResponseBody
    public String home(@RequestParam int id,String name,int quantity,String genre) {
      
		Product product=new Product();
		product.setBoodid(id);
		product.setBookName(name);
		product.setQuantity(quantity);
		product.setGenre(genre);
		
		repository.save(product);
        return "Welcome to Library Management";
    }
	
	
	
	@RequestMapping("/saveBooks")
	@ResponseBody
	public List<Product> getProducts()
	{
		
		return repository.findAll();
	}
	
	
	
	@GetMapping("/deleteBook")
	@ResponseBody
	public String deleteProducts(@RequestParam int id)
	{
	
	    repository.deleteById(id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/getBookByType")
	@ResponseBody
	public ResponseEntity<List<Product>> getProductsByType(@RequestParam String genre) {
			return new ResponseEntity<List<Product>>(repository.findBygenreLike("%"+genre+"%"), HttpStatus.OK);
		}
		   
		   
	
	
	

}
