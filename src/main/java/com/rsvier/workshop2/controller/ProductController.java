package com.rsvier.workshop2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rsvier.workshop2.domain.Product;
import com.rsvier.workshop2.repository.ProductRepository;

@Controller
@RequestMapping("/product")
@SessionAttributes("product")
public class ProductController {

	private ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@ModelAttribute("product")
	public Product product() {
		return new Product();
	}

	@GetMapping("/createNewProduct")
	public String showCreateProductPage() {
		return "createNewProductForm";
	}

	@PostMapping("/createNewProduct")
	public String addProduct(Product product, Model model) {

		String productAdded = "Het product is aangemaakt";
		model.addAttribute("editMessage", productAdded);

		return "employeeMainMenu";
	}

}
