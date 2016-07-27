package com.niit.backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductTest {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		product.setId("pro1");
		product.setName("teddy");
		product.setDescription("cute");
		product.setPrice("500");
		productDAO.saveOrUpdate(product);
		
		productDAO.delete("pro_1");
		productDAO.get("pro_1");
	
		List<Product>  list =    productDAO.list();
		
		for(Product Pro : list)
		{
			System.out.println(Pro.getId()  + ":" +  Pro.getName()  + ":"+  Pro.getDescription() +":"+ Pro.getPrice());
		}
			
			
		context.close();
		
	}
}


