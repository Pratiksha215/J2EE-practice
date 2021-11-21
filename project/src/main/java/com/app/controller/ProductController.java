package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IProductDao;
import com.app.pojos.Product;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	//dependency : service i/f
	@Autowired
	private IProductService service;
	
	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	//req handling method to display all products
	@GetMapping("/list")
	public String listProducts(Model map)
	{
		System.out.println("in list products "+map);
		map.addAttribute("product_list", service.getAllProducts());
		return "/product/list";//forward view : actual view : /WEB-INF/views/product/list.jsp
	}
	//request handling method for deleting a product by id.
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam int prodId,RedirectAttributes flashMap)
	{
		System.out.println("in delete products");
		flashMap.addFlashAttribute("status", service.deleteProduct(prodId));
		return "redirect:/product/list";//D.S : response.sendRedirect(response.encodeRedirectURL("/product/list"))
	}
	//req handling method to show add product form
	@GetMapping("/add")
	public String showAddProductForm(Product p)
	{
		System.out.println("in show product form");
		//How to tell SC to bind form data to model (POJO):Product?
		//Simply add Product pojo transient instance as a model attribute(in Model map)
	     //  map.addAttribute("product",new Product());//1st step in form binding:Sc uses model attr name 
		//derived from POJO class name
		return "/product/add";//Vr:/WEB-INF/views/product/add.jsp
	}
	// add req handling method to process the form
		@PostMapping("/add")
		public String processAddProductForm(Product transientPopulatedProduct,
				RedirectAttributes flashMap) {
			System.out.println("in process form "+transientPopulatedProduct);
			//invoke service---dao --add product to db
			flashMap.addFlashAttribute("status",service.addProduct(transientPopulatedProduct));
			return "redirect:/product/list";// D.S : resp.sendRedirect(resp.encodeRedirectURL("/product/list"))
		}
}
