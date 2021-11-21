package com.example.OnlineShoppingSystem.controller;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.OnlineShoppingSystem.domain.Product;
import com.example.OnlineShoppingSystem.domain.User;
import com.example.OnlineShoppingSystem.repository.CartRepository;
import com.example.OnlineShoppingSystem.repository.ProductRepository;
import com.example.OnlineShoppingSystem.repository.UserRepository;
import com.example.OnlineShoppingSystem.domain.AdminLogin;
import com.example.OnlineShoppingSystem.domain.Cart;
import com.example.OnlineShoppingSystem.domain.Login;
import com.example.OnlineShoppingSystem.service.AdminLoginService;
import com.example.OnlineShoppingSystem.service.CartService;
import com.example.OnlineShoppingSystem.service.FileUploadService;
import com.example.OnlineShoppingSystem.service.LoginService;
import com.example.OnlineShoppingSystem.service.ProductService;
import com.example.OnlineShoppingSystem.service.RegisterService;


@Controller
public class ProductController {
	
	private  String username ="";
	private int id=0;
	
	 @Autowired
	    private ProductService service;
	 
	 @Autowired
	    private CartService Cartservice;
	 
	 @Autowired
	 	private RegisterService register;
	 
	 @Autowired
	 	private LoginService loginService;
	 
	 @Autowired
	 	private AdminLoginService adminloginService;
	 
	 @Autowired FileUploadService fileUploadService;

	 @Autowired
		private ProductRepository productRepo;
	 
	 @Autowired
		private CartRepository CartRepo;
	 
	 @Autowired
	 	private UserRepository userRepo;
	 
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<Product> listproduct = service.listAll();
	        model.addAttribute("listproduct", listproduct);
	        System.out.print("Get / ");	
	        return "index";
	    }
	    
        
@GetMapping("/login")
public ModelAndView login() {
ModelAndView mav = new ModelAndView("login");
mav.addObject("user", new Login());
return mav;
}

@PostMapping("/login")
public String login(Model model,@ModelAttribute("user") Login user ) {

	Login oauthUser = loginService.login(user.getUsername(), user.getPassword());
	username = user.getUsername();
	model.addAttribute("username", user.getUsername());
	System.out.print("Username ID :"+oauthUser.getId());
	id = oauthUser.getId();
if(Objects.nonNull(oauthUser)) 
{	

return "redirect:/ReceiveProducts";


} else {
return "redirect:/";


}    
}    

@GetMapping("/adminlogin")
public ModelAndView adminlogin() {
ModelAndView mav = new ModelAndView("adminlogin");
mav.addObject("adminlogin", new AdminLogin());
return mav;
}

@PostMapping("/adminlogin")
public String adminlogin(Model model,@ModelAttribute("adminlogin") AdminLogin user ) {

	AdminLogin oauthUser = adminloginService.login(user.getUsername(), user.getPassword());
	username = user.getUsername();
	model.addAttribute("username", user.getUsername());
	System.out.print("Username ID :"+oauthUser.getId());
	//id = oauthUser.getId();
if(Objects.nonNull(oauthUser)) 
{	

return "redirect:/Home";


} else {
return "redirect:/AdminLogin";


}    
} 

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("product", new Product());
	        return "new";
	    }
	    
	    @GetMapping("/AdminLogin")
	    public String admin(Model model) {
	        model.addAttribute("product", new Product());
	        return "AdminLogin";
	    }
	    
	    @GetMapping("/listProducts")
	    public String list(Model model) {
	    	List<Product> products=productRepo.findAll();
	        model.addAttribute("products", products); 
	        return "listProducts";
	    } 
	    
	    @GetMapping("/register")
	    public String send(Model model) {
	        model.addAttribute("product", new Product());
	        return "UserRegistration";
	    }
	    
	    @GetMapping("/Home")
	    public String home(Model model) {
	        System.out.println("Username : "+username);
	        return "Home";
	    }
	    
	    @GetMapping("/ViewProduct")
	    public String viewProduct(Model model) {
	        model.addAttribute("product", new Product());
	        return "ViewProduct";
	    }
	    
	    @RequestMapping(value = "/PaymentPage", method = RequestMethod.POST)
	    public String payment(Model model,
	    		@RequestParam("product_total")int product_total) {
	    	
	        model.addAttribute("total",product_total );
	        return "PaymentPage";
	    }
	    
	    @RequestMapping(value = "/ClearCart", method = RequestMethod.POST)
	    public String clearCart(Model model,
	    		@RequestParam("cc_exp_mo")String message) {  	
	        model.addAttribute("cc_exp_mo",message );
	        System.out.println(message);
	        Cartservice.clearCart(id);
	        return "redirect:/ReceiveProducts";
	    }
	    
	    @GetMapping("/ReceiveProducts")
	    public String receiveProduct(Model model) {
	    	List<Product> products=productRepo.findAll();
	        model.addAttribute("products", products);
	        return "ReceiveProducts";
	    }
	    
	    @GetMapping("/ViewProfile")
	    public String viewProfile(Model model) {
	    	System.out.println("Username :" + username+" and ID :" +id);
	    	User user=register.get(id);
	    	System.out.println("First_Name : "+ user.getFirst_name());
	        model.addAttribute("user", user);
	        return "ViewProfile";
	    }
	    
	    @RequestMapping("/ViewProduct/{id}")
	    public String viewmyproduct(@PathVariable(name = "id") String value, Model model) {
	    	System.out.println("Username :" + username+" and ID :" +value);
	    	int id1 = Integer.parseInt(value);
	    	System.out.println("Username :" + username+" and ID :" +id1);
	    	Product product=service.get(id1);
	    	System.out.println("First_Name : "+ product.getProduct_name());
	        model.addAttribute("product", product);
	        return "ViewProduct";
	    }
	    
	    @GetMapping("/AddProduct")
	    public String addProduct(Model model) {
	        model.addAttribute("product", new Product());
	        return "AddProduct";
	    }
	    
	    @RequestMapping(value = "/test", method = RequestMethod.POST)
	    public String saveProduct(@RequestParam("product_state") String state,
	    		@RequestParam("product_festival") String festival,
	    		@RequestParam("product_accessories") String accessories,Model model)
	    {
	    	
	    	System.out.println(state+"    "+festival+"    "+accessories);
	        model.addAttribute("product", new Product());
	    
	        
	        return "Test";
	    }
	    
	    @GetMapping("/MyCart")
	    public String cart(Model model) {
	    	List<Cart> products = Cartservice.getByUser(id);
	        model.addAttribute("products", products);
	       
	        return "MyCart";
	    }
	    
	    @PostMapping
	    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException
	    {
	    	fileUploadService.uploadFile(file);
	    }
	    
	    
	    

	    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	    public String saveProduct(@RequestParam("product_photo") MultipartFile file,
	    		@RequestParam("product_name")String product_name,
	    		@RequestParam("product_info")String product_info,
	    		@RequestParam("product_state")String product_state,
	    		@RequestParam("product_festival")String product_festival,
	    		@RequestParam("product_accessories")String product_accessories,
	    		@RequestParam("product_price")int product_price,
	    		@RequestParam("product_quantity")int product_quantity
	    		
	    		) throws IllegalStateException, IOException {
	    	
	    	Product product= new Product();
	    	
	    	product.setProduct_name(product_name);
	    	product.setProduct_info(product_info);
	    	product.setProduct_photo(Base64.getEncoder().encodeToString(file.getBytes()));
	    	product.setProduct_state(product_state);
	    	product.setProduct_festival(product_festival);
	    	product.setProduct_accessories(product_accessories);
	    	product.setProduct_price(product_price);
	    	product.setProduct_quantity(product_quantity);
	    	
	    	System.out.println(file.getName());
	        service.save(product);
	        
	     //   fileUploadService.uploadFile(file);
	        
	        return "redirect:/Home";
	    }
	    
	    @RequestMapping(value = "/saveCart", method = RequestMethod.POST)
	    public String saveCart(@RequestParam("product_photo") String file,
	    		@RequestParam("product_name")String product_name,
	    		@RequestParam("product_info")String product_info,
	    		@RequestParam("product_price")int product_price,
	    		@RequestParam("product_quantity")int product_quantity
	    		
	    		) throws IllegalStateException, IOException {
	    	
	    	Cart cart= new Cart();
	    	cart.setProduct_name(product_name);
	    	cart.setProduct_info(product_info);
	    	cart.setProduct_photo(file);
	    	cart.setProduct_price(product_price);
	    	cart.setProduct_quantity(product_quantity);
	    	cart.setProduct_total(product_quantity*product_price);
	    	cart.setUser_id(id);
	    	
	    	System.out.println("Success");
	        Cartservice.save(cart);
	        
	     //   fileUploadService.uploadFile(file);
	        
	        return "redirect:/MyCart";
	    }
	    
	    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	    public String saveUser(@ModelAttribute("user") User std) {
	        register.save(std);
	        return "redirect:/";
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        Product std = service.get(id);
	        mav.addObject("product", std);
	        return mav;
	        
	    }
	    @RequestMapping("/RemoveProduct/{id}")
	    public String deleteproduct(@PathVariable(name = "id") String value) {
	    
	    	System.out.println("String :"+value);
	    	int id = Integer.parseInt(value);
	    	System.out.println("Int :"+id);
	       service.delete(id);
	        return "redirect:/listProducts";
	    }
}