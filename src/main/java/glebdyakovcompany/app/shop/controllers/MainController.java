package glebdyakovcompany.app.shop.controllers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
// import javax.servlet.http.HttpServletRequest;
// import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.hateoas.Link;
// import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
// import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import glebdyakovcompany.app.shop.models.OrderModel;
import glebdyakovcompany.app.shop.models.ProductModel;
import net.minidev.json.JSONObject;

// import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

// import glebdyakovcompany.app.shop.models.OrderModel;
// import glebdyakovcompany.app.shop.models.UserModel;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.apache.tomcat.util.http.fileupload.IOUtils;
// import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
// import java.io.InputStream;
// import java.io.RandomAccessFile;
import java.net.URI;
// import java.net.URL;
import java.util.ArrayList;
// import java.util.Optional;

// import javax.servlet.ServletContext;


@Controller
public class MainController {
    
	public glebdyakovcompany.app.shop.models.ProductModel currentProduct;
	public boolean userExists = false;
	public int commonPrice = 0;
	public int cursorOfDelete = -1;
	public int indexOfDelete = -1;
	public glebdyakovcompany.app.shop.models.UserModel currentUser;
	ArrayList<glebdyakovcompany.app.shop.models.OrderModel> orders = new ArrayList<glebdyakovcompany.app.shop.models.OrderModel>();
	
	@Autowired
	public glebdyakovcompany.app.shop.services.repositories.UserRepository userRepository;
	
	@Autowired
	public glebdyakovcompany.app.shop.services.repositories.OrderRepository orderRepository;
	
	@Autowired
	public glebdyakovcompany.app.shop.services.repositories.ProductRepository productRepository;

	public glebdyakovcompany.app.shop.dao.ProductDAO productDAO;

	public glebdyakovcompany.app.shop.dao.OrderDAO orderDAO;

	// @Autowired
	public glebdyakovcompany.app.shop.services.IProductService productService;

	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String build() throws IOException {
		
		// ServletContext servletContext = new ServletContext();
		// InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");
		// return IOUtils.toByteArray(in);

		// RandomAccessFile f = new RandomAccessFile("D:/springapps/shop/vue-super-shop/dist/index.html", "r");
		// byte[] b = new byte[(int)f.length()];
		// f.readFully(b);
		// final HttpHeaders headers = new HttpHeaders();
    	// headers.setContentType(MediaType.TEXT_HTML);
		// return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
		
		return "index";
		
	}

	@CrossOrigin
    @RequestMapping(value = "/encode", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String encode(@RequestParam String userpassword)  {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userpassword);
		return "{\"encodedpassword\":\"" + encodedPassword +"\"}";
	}

	@CrossOrigin
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String home()  {
		
		System.out.println("productRepository.findAll().toString(): " + productRepository.findAll().toString());
		String[]  productsJSON = productRepository.findAll().toString().split("\'");
		System.out.println("productsJSON: " + productsJSON);
		String productsJSONJoin = String.join("\"", productsJSON);
		System.out.println("productsJSONJoin: " + productsJSONJoin);
		
		
		// return productRepository.findAll();
		// return "{\"allProducts\":\"" + productRepository.findAll() + "\"}";
		return "{\"allProducts\":" + productsJSONJoin + "}";
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/delete", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketDelete(@RequestParam String useremail, @RequestParam String productid)  {
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 0, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 0, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("id", "1");
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("id", "2");
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);
		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("id", "1");
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("id", "2");
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("this.currentUser: " + this.currentUser.email);
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// this.currentUser.getProductsInBucket().forEach((product) -> {
		// 	System.out.println("product.get(id): " + product.get("id"));
		// 	this.cursorOfDelete++;
		// 	Object currentProductId = product.get("id");
		// 	if(currentProductId.toString().contains(productid)){
		// 		this.indexOfDelete = this.cursorOfDelete;
		// 		System.out.println("Нашёл");
		// 	} else if(!currentProductId.toString().contains(productid)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// if(indexOfDelete >= 0){
		// 	this.currentUser.getProductsInBucket().remove(this.indexOfDelete);
		// }
		// return "{\"status\":\"OK\",\"message\":\"success\",\"products\":\"" + this.currentUser.getProductsInBucket().get(0).get("id") + "\"}";
		
		this.cursorOfDelete = 0;
		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				System.out.println("this.currentUser: " + this.currentUser.email);
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		this.currentUser.getProductsInBucket().forEach((product) -> {
			System.out.println("product.get(id): " + product.get("id"));
			this.cursorOfDelete++;
			Object currentProductId = product.get("id");
			if(currentProductId.toString().contains(productid)){
				this.indexOfDelete = this.cursorOfDelete;
				System.out.println("Нашёл");
			} else if(!currentProductId.toString().contains(productid)){
				System.out.println("Не нашёл");
			}
		});
		if(indexOfDelete >= 0){
			this.currentUser.getProductsInBucket().remove(this.indexOfDelete);
			userRepository.save(this.currentUser);
		}
		return "{\"status\":\"OK\",\"message\":\"success\",\"products\":\"" + this.currentUser.getProductsInBucket().get(0).get("id") + "\"}";

	}

	@CrossOrigin
	@RequestMapping(value = "/users/amount", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersAmount(@RequestParam String useremail, @RequestParam int amount)  {
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 0, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 0, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		// System.out.println("amount: " + amount);
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);
		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("this.currentUser: " + this.currentUser.email);
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// this.currentUser.moneys += amount;
		// return "{\"status\":\"OK\",\"moneys\":\"" + this.currentUser.getMoneys() + "\",\"message\":\"success\"}";
	
		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				user.moneys += amount;
				userRepository.save(user);
			}
		});
		return "{\"status\":\"OK\",\"moneys\":\"" + this.currentUser.getMoneys() + "\",\"message\":\"success\"}";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/users/bucket", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucket(@RequestParam String useremail)  {
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 0, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 0, new ArrayList<Map<String, Object>>()));
		
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);

		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("this.currentUser: " + this.currentUser.email);
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// ArrayList<Object> myProductsInBucket = new ArrayList<Object>(); 
		// this.currentUser.productsInBucket.forEach((productInBucket) -> {
		// 	myProductsInBucket.add(productInBucket);
		// });
		// return "{\"productsInBucket\":\"" + myProductsInBucket + "\",\"message\":\"success\"}";
	
		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				System.out.println("this.currentUser: " + this.currentUser.email);
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		ArrayList<Object> myProductsInBucket = new ArrayList<Object>(); 
		this.currentUser.productsInBucket.forEach((productInBucket) -> {
			myProductsInBucket.add(productInBucket);
		});
		String[]  myProductsInBucketJSON = myProductsInBucket.toString().split("=");
		String myProductsInBucketJSONjoin = String.join(":", myProductsInBucketJSON);
		return "{\"productsInBucket\":\"" + myProductsInBucketJSONjoin + "\",\"message\":\"success\"}";
	
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/buy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketBuy(@RequestParam String useremail) {
		// ArrayList<glebdyakovcompany.app.shop.models.OrderModel> orders = new ArrayList<glebdyakovcompany.app.shop.models.OrderModel>();
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 15000, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 120, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("id", "1");
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("id", "2");
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);
		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("id", "1");
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("id", "2");
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("this.currentUser: " + this.currentUser.email);
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// this.currentUser.getProductsInBucket().forEach((product) -> {
		// 	System.out.println("product.get(price): " + product.get("price"));
		// 	Object currentProductPrice = product.get("price");
		// 	this.commonPrice += Integer.parseInt(currentProductPrice.toString());
		// });
		// if(this.currentUser.moneys >= this.commonPrice){
		// 	int incrementedId = orders.toArray().length + 1;
		// 	String newStringId = Integer.toString(incrementedId);
		// 	Long newId = Long.parseLong(newStringId);
		// 	glebdyakovcompany.app.shop.models.OrderModel newOrder = new glebdyakovcompany.app.shop.models.OrderModel(newId, useremail, this.commonPrice);
		// 	orders.add(newOrder);
		// 	this.currentUser.moneys -= this.commonPrice;
		// 	this.currentUser.getProductsInBucket().clear();
		// 	return "{\"status\":\"OK\",\"message\":\"success\",\"orders\":\"" + orders.get(0) + "\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";	
		// } else if(this.currentUser.moneys < this.commonPrice){
		// 	return "{\"status\":\"Error\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";	
		// }
		// return "{\"status\":\"Error\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";	
	
		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				System.out.println("this.currentUser: " + this.currentUser.email);
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		this.currentUser.getProductsInBucket().forEach((product) -> {
			System.out.println("product.get(price): " + product.get("price"));
			Object currentProductPrice = product.get("price");
			this.commonPrice += Integer.parseInt(currentProductPrice.toString());
		});
		if(this.currentUser.moneys >= this.commonPrice){
			Long newId = orderRepository.count() + 1;
			// glebdyakovcompany.app.shop.models.OrderModel newOrder = new glebdyakovcompany.app.shop.models.OrderModel(newId, useremail, this.commonPrice);
			glebdyakovcompany.app.shop.models.OrderModel newOrder = new glebdyakovcompany.app.shop.models.OrderModel(useremail, this.commonPrice);
			orderRepository.save(newOrder);
			this.currentUser.moneys -= this.commonPrice;
			this.currentUser.getProductsInBucket().clear();
			userRepository.save(this.currentUser);
			return "{\"status\":\"OK\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";	
		} else if(this.currentUser.moneys < this.commonPrice){
			return "{\"status\":\"Error\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";	
		}
		return "{\"status\":\"Error\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"commonPrice\":\"" + this.commonPrice + "\"}";
	}

	@CrossOrigin
	@RequestMapping(value = "/userscreatesuccess", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersCreateSuccess(@RequestParam String useremail, @RequestParam String userpassword, @RequestParam String username, @RequestParam int userage) {
		// ArrayList<glebdyakovcompany.app.shop.models.OrderModel> orders = new ArrayList<glebdyakovcompany.app.shop.models.OrderModel>();
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 15000, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 120, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("id", "1");
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("id", "2");
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);
		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("id", "1");
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("id", "2");
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.userExists = true;
		// 		System.out.println("Нашёл");
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// if(this.userExists){
        //     return "{\"status\":\"rollback\",\"message\":\"rollback\"}";	
        // } else {
		// 	String encodedPassword = "#";
        //     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 	encodedPassword = passwordEncoder.encode(userpassword);
		// 	int incrementedId = users.toArray().length + 1;
		// 	String newStringId = Integer.toString(incrementedId);
		// 	Long newId = Long.parseLong(newStringId);
		// 	ArrayList<Map<String, Object>> bucket = new ArrayList<Map<String, Object>>();
		// 	glebdyakovcompany.app.shop.models.UserModel newUser = new glebdyakovcompany.app.shop.models.UserModel(newId, useremail, encodedPassword, username, userage, 0, bucket);
		// 	users.add(newUser);
		// 	this.currentUser = newUser;
		// }
		// return "{\"status\":\"OK\",\"message\":\"success\",\"moneys\":\"" + this.currentUser.moneys + "\",\"age\":\"" + this.currentUser.age + "\",\"name\":\"" + this.currentUser.name + "\",\"email\":\"" + this.currentUser.email + "\",\"password\":\"" + this.currentUser.password + "\",\"productsInBucket\":\"" + this.currentUser.productsInBucket + "\",\"id\":\"" + this.currentUser.id + "\"}";	
	
		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.userExists = true;
				System.out.println("Нашёл");
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		if(this.userExists){
			return "{\"status\":\"rollback\",\"message\":\"rollback\"}";	
		} else {
			String encodedPassword = "#";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			encodedPassword = passwordEncoder.encode(userpassword);
			Long newId = userRepository.count() + 1;
			ArrayList<Map<String, Object>> bucket = new ArrayList<Map<String, Object>>();
			// glebdyakovcompany.app.shop.models.UserModel newUser = new glebdyakovcompany.app.shop.models.UserModel(newId, useremail, encodedPassword, username, userage, 0, bucket);
			glebdyakovcompany.app.shop.models.UserModel newUser = new glebdyakovcompany.app.shop.models.UserModel(useremail, encodedPassword, username, userage, 0, bucket);
			userRepository.save(newUser);
		}
		return "{\"status\":\"OK\",\"message\":\"success\"}";	
	
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/add", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketAdd(@RequestParam String useremail, @RequestParam String productname, @RequestParam int productprice) {
		// ArrayList<glebdyakovcompany.app.shop.models.OrderModel> orders = new ArrayList<glebdyakovcompany.app.shop.models.OrderModel>();
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "#######", "alex", 16, 15000, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 120, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("id", "1");
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("id", "2");
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);
		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("id", "1");
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("id", "2");
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("Нашёл");
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// HashMap<String, Object> lastProductInBucket = new HashMap<String, Object>();
		// lastProductInBucket.put("name", productname);
		// lastProductInBucket.put("price", productprice);
		// this.currentUser.getProductsInBucket().add(lastProductInBucket);
		// return "{\"status\":\"OK\",\"message\":\"success\",\"productsInBucket\":\"" + this.currentUser.productsInBucket.size() + "\"}";	

		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				System.out.println("Нашёл");
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		HashMap<String, Object> lastProductInBucket = new HashMap<String, Object>();
		lastProductInBucket.put("name", productname);
		lastProductInBucket.put("price", productprice);
		
		// this.currentUser.getProductsInBucket().add(lastProductInBucket);
		
		ArrayList<Map<String, Object>> updatedBucket = this.currentUser.getProductsInBucket();
		updatedBucket.add(lastProductInBucket);
		this.currentUser.setProductsInBucket(updatedBucket);

		userRepository.save(this.currentUser);
		return "{\"status\":\"OK\",\"message\":\"success\",\"productsInBucket\":\"" + this.currentUser.productsInBucket.size() + "\"}";	

	}

	@CrossOrigin
	@RequestMapping(value = "/product/{productID}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String productByID(@PathVariable("productID") String productID) {
		
		// ArrayList<glebdyakovcompany.app.shop.models.ProductModel> products = new ArrayList<glebdyakovcompany.app.shop.models.ProductModel>();
		// long firstId = 1;
		// products.add(new glebdyakovcompany.app.shop.models.ProductModel(firstId, "divan", 280));
		// long secondId = 2;
		// products.add(new glebdyakovcompany.app.shop.models.ProductModel(secondId, "cycle", 375));
		
		// products.forEach((product) -> {
		// 	Object objectId = product.id;
		// 	String stringId = objectId.toString();
		// 	if(stringId.contains(productID)){
		// 		System.out.println("Нашёл");
		// 		this.currentProduct = product;
		// 	} else if(!stringId.contains(productID)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// return "{\"message\":\"success\",\"product\":\"" + this.currentProduct.name + "\"}";	
	
		productRepository.findAll().forEach((product) -> {
			Object objectId = product.id;
			String stringId = objectId.toString();
			if(stringId.contains(productID)){
				System.out.println("Нашёл");
				this.currentProduct = product;
			} else if(!stringId.contains(productID)){
				System.out.println("Не нашёл");
			}
		});
		return "{\"message\":\"success\",\"product\":\"" + this.currentProduct + "\"}";	
	
	}

	@CrossOrigin
	@RequestMapping(value = "/users/check", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersCheck(@RequestParam String useremail, @RequestParam String userpassword) {
		
		// ArrayList<glebdyakovcompany.app.shop.models.UserModel> users = new ArrayList<glebdyakovcompany.app.shop.models.UserModel>();
		// long firstId = 1;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(firstId, "alex@mail.ru", "$2a$10$b86IItK8SXH7lSVmbP8kaO/LPBZhonx0jZ8jknlzBtcqEGc2Qk47K", "alex", 16, 15000, new ArrayList<Map<String, Object>>()));
		// long secondId = 2;
		// users.add(new glebdyakovcompany.app.shop.models.UserModel(secondId, "cris@mail.ru", "#######", "cris", 18, 120, new ArrayList<Map<String, Object>>()));
		// System.out.println("email: " + useremail);
		
		// HashMap<String, Object> firstProductInFirstBucket = new HashMap<String, Object>();
		// firstProductInFirstBucket.put("id", "1");
		// firstProductInFirstBucket.put("name", "box");
		// firstProductInFirstBucket.put("price", 30);
		// HashMap<String, Object> secondProductInFirstBucket = new HashMap<String, Object>();
		// secondProductInFirstBucket.put("id", "2");
		// secondProductInFirstBucket.put("name", "pen");
		// secondProductInFirstBucket.put("price", 15);
		// users.get(0).getProductsInBucket().add(firstProductInFirstBucket);
		// users.get(0).getProductsInBucket().add(secondProductInFirstBucket);

		// HashMap<String, Object> firstProductInSecondBucket = new HashMap<String, Object>();
		// firstProductInSecondBucket.put("id", "1");
		// firstProductInSecondBucket.put("name", "tv");
		// firstProductInSecondBucket.put("price", 200);
		// HashMap<String, Object> secondProductInSecondBucket = new HashMap<String, Object>();
		// secondProductInSecondBucket.put("id", "2");
		// secondProductInSecondBucket.put("name", "juice");
		// secondProductInSecondBucket.put("price", 75);
		// users.get(1).getProductsInBucket().add(firstProductInSecondBucket);
		// users.get(1).getProductsInBucket().add(secondProductInSecondBucket);
		
		// users.forEach((user) -> {
		// 	if(user.email.contains(useremail)){
		// 		this.currentUser = user;
		// 		System.out.println("Нашёл");
		// 	} else if(!user.email.contains(useremail)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });
		// boolean passwordCheck = false;
		// BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
		// passwordCheck = bcrypt.matches(userpassword, this.currentUser.getPassword()) && userpassword.length() >= 1;
		
		// System.out.println("userpassword: " + userpassword);
		// System.out.println("this.currentUser.getPassword(): " + this.currentUser.getPassword());
		// System.out.println("bcrypt.matches(userpassword, this.currentUser.getPassword()): " + bcrypt.matches(userpassword, this.currentUser.getPassword()));

		// if(useremail.contains(this.currentUser.email) && passwordCheck){
		// 	return "{\"user\":\"" + this.currentUser + "\",\"status\":\"OK\"}";
		// }
		// return "{\"status\":\"Error\"}";

		userRepository.findAll().forEach((user) -> {
			if(user.email.contains(useremail)){
				this.currentUser = user;
				System.out.println("Нашёл");
			} else if(!user.email.contains(useremail)){
				System.out.println("Не нашёл");
			}
		});
		boolean passwordCheck = false;
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
		passwordCheck = bcrypt.matches(userpassword, this.currentUser.getPassword()) && userpassword.length() >= 1;
		if(useremail.contains(this.currentUser.email) && passwordCheck){
			return "{\"user\":\"" + this.currentUser.toString() + "\",\"status\":\"OK\"}";
		}
		return "{\"status\":\"Error\"}";

	}

	@CrossOrigin
	@RequestMapping(value = "/admin/products/add", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String adminProductsAdd(@RequestParam String productname, @RequestParam int productprice) {
		
		// ArrayList<glebdyakovcompany.app.shop.models.ProductModel> products = new ArrayList<glebdyakovcompany.app.shop.models.ProductModel>();
		// long firstId = 1;
		// products.add(new glebdyakovcompany.app.shop.models.P1roductModel(firstId, "divan", 280));
		// long secondId = 2;
		// products.add(new glebdyakovcompany.app.shop.models.ProductModel(secondId, "cycle", 375));
		// int incrementedId = products.toArray().length + 1;
		// String newStringId = Integer.toString(incrementedId);
		// Long newId = Long.parseLong(newStringId);
		// glebdyakovcompany.app.shop.models.ProductModel newProduct = new glebdyakovcompany.app.shop.models.ProductModel(newId, productname, productprice);
		// products.add(newProduct);
		// return "{\"status\":\"OK\",\"products\":\"" + products.size() + "\"}";

		Long newId = productRepository.count() + 1;
		// glebdyakovcompany.app.shop.models.ProductModel newProduct = new glebdyakovcompany.app.shop.models.ProductModel(newId, productname, productprice);
		glebdyakovcompany.app.shop.models.ProductModel newProduct = new glebdyakovcompany.app.shop.models.ProductModel(productname, productprice);
		productRepository.save(newProduct);
		return "{\"status\":\"OK\"}";

	}

	@CrossOrigin
	@RequestMapping(value = "/admin/products/delete", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String adminProductsDelete(@RequestParam String productname) {
		
		// ArrayList<glebdyakovcompany.app.shop.models.ProductModel> products = new ArrayList<glebdyakovcompany.app.shop.models.ProductModel>();
		// long firstId = 1;
		// products.add(new glebdyakovcompany.app.shop.models.ProductModel(firstId, "divan", 280));
		// long secondId = 2;
		// products.add(new glebdyakovcompany.app.shop.models.ProductModel(secondId, "cycle", 375));
		// products.forEach((product) -> {
		// 	this.cursorOfDelete++;
		// 	if(product.name.contains(productname)){
		// 		products.remove(this.cursorOfDelete);
		// 		System.out.println("Нашёл");
		// 	} else if(!product.name.contains(productname)){
		// 		System.out.println("Не нашёл");
		// 	}
		// });


		productRepository.findAll().forEach((product) -> {
			if(product.name.contains(productname)){
				productRepository.delete(product);
				System.out.println("Нашёл");
			} else if(!product.name.contains(productname)){
				System.out.println("Не нашёл");
			}
		});
		return "{\"status\":\"OK\"}";
	}

	@CrossOrigin
	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<OrderModel> adminOrders() {
		
		// ArrayList<glebdyakovcompany.app.shop.models.OrderModel> orders = new ArrayList<glebdyakovcompany.app.shop.models.OrderModel>();
		
		// int incrementedId = orders.toArray().length + 1;
		// String newStringId = Integer.toString(incrementedId);
		// Long newId = Long.parseLong(newStringId);
		// glebdyakovcompany.app.shop.models.OrderModel newOrder = new glebdyakovcompany.app.shop.models.OrderModel(newId, "George", 50);
		// orders.add(newOrder);

		// incrementedId = orders.toArray().length + 1;
		// newStringId = Integer.toString(incrementedId);
		// newId = Long.parseLong(newStringId);
		// newOrder = new glebdyakovcompany.app.shop.models.OrderModel(newId, "Fred", 44);
		// orders.add(newOrder);
		
		// return "{"+ orders + "}";

		return orderRepository.findAll();
	}
	
	// public @ResponseBody RedirectView others(HttpServletRequest request) {
	@CrossOrigin
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public RedirectView others() throws FileNotFoundException {
	// public String others() throws FileNotFoundException {
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI newUri = builder.build().toUri();
		return new RedirectView("/?redirecttoroute=" + newUri.getPath());
		// return "redirect:/?redirecttoroute=" + newUri.getPath();
	}

}