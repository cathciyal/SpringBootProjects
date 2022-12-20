package com.example.Products.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Products.entity.Product;
import com.example.Products.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String home(@RequestParam int id,String name,String des,int quan,int price,String type)
	{
		
		Product product=new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setDescription(des);
		product.setQuantity(quan);
		product.setPrice(price);
		product.setType(type);
		repository.save(product);
		return "E-COMMERCE APPLICATION USING SPRING BOOT";
	}
	
	@RequestMapping("/getByType")
	@ResponseBody
	public ResponseEntity<List<Product>> getProductsByType(@RequestParam String type) {
		return new ResponseEntity<List<Product>>(repository.findBytypeLike("%"+type+"%"), HttpStatus.OK);
	}
	
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public String DeleteProduct(@RequestParam int id)
	{
		repository.deleteById(id);
		return "Successfully deleted!";
	}
	
	@RequestMapping("/getAllProducts")
	@ResponseBody
	public List<Product> GetAll()
	{
		return repository.findAll();
	}
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public Optional<Product> GetById(@RequestParam int id)
	{
		return repository.findById(id);
	}
}
