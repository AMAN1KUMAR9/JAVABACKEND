package CRUD.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import CRUD.model.ProductModel;
import CRUD.services.ProductServices;

@Controller
public class CrudController {
	@Autowired
	private ProductServices productServices;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		List<ProductModel> products = (List<ProductModel>) productServices.productGetAll();
		model.addAttribute("products", products );
		
		return "index";
	}
	
	@RequestMapping("/") 
	public String index() {
		
		return "redirect:/home";
	}
	
	
	@RequestMapping("/add-product") 
	public String addProduct(Model m) {
		m.addAttribute("title", "add-product");
		return "addproductform";
	}
	
//	@RequestMapping(value = "/handle-product" ,method = RequestMethod.POST)
//	public String redirect (@ModelAttribute ProductModel product ,HttpServletRequest req) {
//		System.out.println(product +"\n" +req.getContextPath());
//		
//		return "redirect:/home";
//	}
	@RequestMapping(value = "/handle-product" ,method = RequestMethod.POST)
	public RedirectView redirect (@ModelAttribute ProductModel product ,HttpServletRequest req) {
		System.out.println(product +"\n" +req.getContextPath());
		
		productServices.productInsert(product);
		RedirectView Rv = new RedirectView();
		Rv.setUrl(req.getContextPath()+"/");
		return Rv;
	}
	
	@RequestMapping("/edit/{productId}") 
	public String editProduct(Model m ,@PathVariable("productId") int id ) {
		ProductModel pm = this.productServices.productGet(id);
		m.addAttribute("product", pm );
		m.addAttribute("id" , id);
		return "update";
	}
	
	@RequestMapping(value = "/delete/{productId}" )
	public String redirect (@PathVariable("productId") int id ) {
		
		this.productServices.productDelete(id);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/edit/handle-product" ,method = RequestMethod.POST)
	public RedirectView redirectUpdate (@ModelAttribute ProductModel product ,HttpServletRequest req) {
		System.out.println(product +"\n" +req.getContextPath());
		
		productServices.productInsert(product);
		RedirectView Rv = new RedirectView();
		Rv.setUrl(req.getContextPath()+"/");
		return Rv;
	}
	
//	@RequestMapping(value = "/handle-update" ,method = RequestMethod.POST)
//	public   RedirectView update ( @ModelAttribute ProductModel product ,HttpServletRequest req ) {
//		
//		
//		
//		RedirectView Rv = new RedirectView();
//		Rv.setUrl(req.getContextPath()+"/"); 
//		
//		return Rv;
//	}
}
