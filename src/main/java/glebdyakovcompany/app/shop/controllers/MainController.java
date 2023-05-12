package glebdyakovcompany.app.shop.controllers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import glebdyakovcompany.app.shop.models.OrderModel;
import glebdyakovcompany.app.shop.models.ProductModel;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import glebdyakovcompany.app.shop.connections.*;

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

	public glebdyakovcompany.app.shop.services.IProductService productService;

	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String build() throws IOException {
		return "index";
	}

	@CrossOrigin
    @RequestMapping(value = "/encode", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String encode(@RequestParam String userpassword)  {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userpassword);
		String json = "{\"encodedpassword\": \"" + encodedPassword +"\"}";
		return json;
	}

	@CrossOrigin
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String home()  {
		String[]  productsJSON = productRepository.findAll().toString().split("\'");
		String productsJSONJoin = String.join("\"", productsJSON);
		String json = "{\"allProducts\": " + productsJSONJoin + "}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/delete", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketDelete(@RequestParam String useremail, @RequestParam String productid)  {
		this.cursorOfDelete = -1;
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
			}
		});
		this.currentUser.getProductsInBucket().forEach((product) -> {
			this.cursorOfDelete++;
			Object currentProductId = product.get("id");
			if (currentProductId.toString().contains(productid)) {
				this.indexOfDelete = this.cursorOfDelete;
			}
		});
		boolean deletedRecordIndexFound = indexOfDelete >= 0
		if (deletedRecordIndexFound) {
			this.currentUser.getProductsInBucket().remove(this.indexOfDelete);
			userRepository.save(this.currentUser);
		}
		Object productId = this.currentUser.getProductsInBucket().get(0).get("id");
		String json = "{\"status\": \"OK\", \"message\": \"success\", \"products\": \"" + productId + "\"}";
		return json;

	}

	@CrossOrigin
	@RequestMapping(value = "/users/amount", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersAmount(@RequestParam String useremail, @RequestParam int amount)  {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
				user.moneys += amount;
				userRepository.save(user);
			}
		});
		int moneys = this.currentUser.getMoneys();
		String json = "{\"status\": \"OK\", \"moneys\": \"" + moneys + "\", \"message\": \"success\"}";
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/users/bucket", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucket(@RequestParam String useremail)  {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
			}
		});
		String[] myProductsInBucketJSON = this.currentUser.toString().split("\'");
		String serCart = String.join("\"", myProductsInBucketJSON);
		String json = "{\"productsInBucket\": " + serCart + ", \"message\": \"success\"}"
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/buy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketBuy(@RequestParam String useremail) {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
			}
		});
		this.currentUser.getProductsInBucket().forEach((product) -> {
			Object currentProductPrice = product.get("price");
			this.commonPrice += Integer.parseInt(currentProductPrice.toString());
		});
		int userMoneys = this.currentUser.moneys;
		boolean isCanBuy = userMoneys >= this.commonPrice;
		if (isCanBuy) {
			Long newId = orderRepository.count() + 1;
			glebdyakovcompany.app.shop.models.OrderModel newOrder = new glebdyakovcompany.app.shop.models.OrderModel(newId, useremail, this.commonPrice);
			orderRepository.save(newOrder);
			this.currentUser.moneys -= this.commonPrice;
			this.currentUser.getProductsInBucket().clear();
			userRepository.save(this.currentUser);
			String json = "{\"status\": \"OK\", \"message\": \"success\", \"moneys\": \"" + this.currentUser.moneys + "\", \"commonPrice\": \"" + this.commonPrice + "\"}";
			return json;
		} else if (this.currentUser.moneys < this.commonPrice) {
			String json = "{\"status\": \"Error\", \"message\": \"success\", \"moneys\": \"" + this.currentUser.moneys + "\", \"commonPrice\": \"" + this.commonPrice + "\"}";
			return json;
		}
		String json = "{\"status\": \"Error\", \"message\": \"success\", \"moneys\": \"" + this.currentUser.moneys + "\", \"commonPrice\": \"" + this.commonPrice + "\"}"
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/users/usercreatesuccess", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String userCreateSuccess(@RequestParam String useremail, @RequestParam String userpassword, @RequestParam String username, @RequestParam int userage) {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.userExists = true;
			}
		});
		if (this.userExists) {
			String json = "{\"status\": \"rollback\", \"message\": \"rollback\"}";
			return json;
		} else {
			String encodedPassword = "#";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			encodedPassword = passwordEncoder.encode(userpassword);
			Long newId = userRepository.count() + 1;
			ArrayList<Map<String, Object>> bucket = new ArrayList<Map<String, Object>>();
			glebdyakovcompany.app.shop.models.UserModel newUser = new glebdyakovcompany.app.shop.models.UserModel(newId, useremail, encodedPassword, username, userage, 0, bucket);
			userRepository.save(newUser);
		}
		String json = "{\"status\": \"created\", \"message\": \"success\"}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/users/bucket/add", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersBucketAdd(@RequestParam String useremail, @RequestParam String productname, @RequestParam int productprice) {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
			}
		});
		HashMap<String, Object> lastProductInBucket = new HashMap<String, Object>();
		Double newGeneratedId = Math.random() * 500;
		Float floatId = Float.parseFloat(newGeneratedId.toString());
		Integer newFloorGeneratedId = Math.round(floatId);
		String stringGeneratedId = newFloorGeneratedId.toString();
		Integer preparedGeneratedId = Integer.parseInt(stringGeneratedId);
		stringGeneratedId = preparedGeneratedId.toString();
		lastProductInBucket.put("id", stringGeneratedId);
		lastProductInBucket.put("name", productname);
		lastProductInBucket.put("price", productprice);
		ArrayList<Map<String, Object>> updatedBucket = this.currentUser.getProductsInBucket();
		updatedBucket.add(lastProductInBucket);
		this.currentUser.setProductsInBucket(updatedBucket);
		userRepository.save(this.currentUser);
		int products = this.currentUser.productsInBucket.size();
		String json = "{\"status\": \"OK\", \"message\": \"success\", \"productsInBucket\": \"" + products + "\"}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/product/{productID}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String productByID(@PathVariable("productID") String productID) {
		productRepository.findAll().forEach((product) -> {
			Object objectId = product.id;
			String stringId = objectId.toString();
			if (stringId.contains(productID)) {
				this.currentProduct = product;
			}
		});
		String[]  productJSON = this.currentProduct.toString().split("\'");
		String productJSONJoin = String.join("\"", productJSON);
		String json = "{\"message\": \"success\", \"product\": " + productJSONJoin + "}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/users/check", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String usersCheck(@RequestParam String useremail, @RequestParam String userpassword) {
		userRepository.findAll().forEach((user) -> {
			boolean isEmailMatch = user.email.contains(useremail);
			if (isEmailMatch) {
				this.currentUser = user;
			}
		});
		boolean passwordCheck = false;
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); 
		int passLen = userpassword.length();
		String userDbPass = this.currentUser.getPassword();
		passwordCheck = bcrypt.matches(userpassword, userDbPass) && passLen >= 1;
		if (useremail.contains(this.currentUser.email) && passwordCheck) {
			String serUser = this.currentUser.toString();
			String json = "{\"user\": \"" + serUser + "\", \"status\": \"OK\"}";
			return json;
		}
		String json = "{\"status\":\"Error\"}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/admin/products/add", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String adminProductsAdd(@RequestParam String productname, @RequestParam int productprice) {
		Long newId = productRepository.count() + 1;
		glebdyakovcompany.app.shop.models.ProductModel newProduct = new glebdyakovcompany.app.shop.models.ProductModel(productname, productprice);
		productRepository.save(newProduct);
		String json = "{\"status\":\"OK\"}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/admin/products/delete", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String adminProductsDelete(@RequestParam String productname) {
		productRepository.findAll().forEach((product) -> {
			if (product.name.contains(productname)) {
				productRepository.delete(product);
			}
		});
		String json = "{\"status\":\"OK\"}";
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<OrderModel> adminOrders() {
		return orderRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public RedirectView others() throws FileNotFoundException {
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI newUri = builder.build().toUri();
		String currentUrl = newUri.getPath()
		String redirectUrl = "/?redirecttoroute=" + currentUrl;
		return new RedirectView(redirectUrl);
	}

}